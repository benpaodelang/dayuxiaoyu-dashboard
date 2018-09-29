package com.dayuxiaoyu.dashboard.service.cms;

import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.TagDao;
import com.dayuxiaoyu.dashboard.model.cms.TagModel;
import com.dayuxiaoyu.dashboard.web.request.cms.*;
import com.dayuxiaoyu.dashboard.web.response.cms.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagService {
    @Resource
    private TagDao tagDao;

    public AddTagResponse add(AddTagRequest addTagRequest) {
        
        TagModel tagModel= new TagModel();
        tagModel.setName(addTagRequest.getName());
        
        TagModel result = this.insert(tagModel);
        
        AddTagResponse addTagResponse = new AddTagResponse(ResultEnum.success);
        addTagResponse.setData(result);
        return addTagResponse;
    }

    public DeleteTagResponse delete(DeleteTagRequest deleteTagRequest) {
        Boolean result = this.deleteByPrimaryKey(deleteTagRequest.getId());
        DeleteTagResponse deleteTagResponse = new DeleteTagResponse(ResultEnum.success);
        deleteTagResponse.setData(result);
        return deleteTagResponse;
    }

    public TagDetailResponse detail(TagDetailRequest tagDetailRequest) {
        TagModel result = this.selectByPrimaryKey(tagDetailRequest.getId());
        TagDetailResponse tagDetailResponse = new TagDetailResponse(ResultEnum.success);
        tagDetailResponse.setData(result);
        return tagDetailResponse;
    }

    public EditTagResponse edit(EditTagRequest editTagRequest) {
        
        TagModel tagModel= new TagModel();
        tagModel.setName(editTagRequest.getName());
        tagModel.setId(editTagRequest.getId());
        Boolean result = this.updateByPrimaryKey(tagModel);
        
        EditTagResponse editTagResponse = new EditTagResponse(ResultEnum.success);
        editTagResponse.setData(result);
        return editTagResponse;
    }

    public TagListResponse search(TagListRequest tagListRequest) {
        return null;
    }

    public TagPageListResponse searchWithPage(TagPageListRequest tagPageListRequest) {
        return null;
    }

    public TagModel insert(TagModel tagModel) {
        return tagDao.addEntity(tagModel);
    }

    public List<TagModel> insertList(List<TagModel> tagModelList) {
        List<TagModel> answer = new ArrayList<TagModel>();
        for(TagModel tagModel : tagModelList ){
            answer.add(this.insert(tagModel));
        }
        return answer;
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return tagDao.deleteEntity(cond);
    }

    public Boolean updateByPrimaryKey(TagModel tagModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",tagModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("name",tagModel.getName());
        return tagDao.updateEntity(cond,updateValue);
    }

    public List<TagModel> selectAll() {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = allColumn();
        return tagDao.findEntityListByCond(cond,output,null);
    }

    public TagModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = allColumn();
        return tagDao.findEntityById(cond,output);
    }

    public Map<String,Object> allColumn(){
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("name","1");
        output.put("id","1");
        return output;
    }
}
