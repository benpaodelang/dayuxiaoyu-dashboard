package com.dayuxiaoyu.dashboard.service.cms;

import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.NewTagDao;
import com.dayuxiaoyu.dashboard.model.cms.NewTagModel;
import com.dayuxiaoyu.dashboard.web.request.cms.*;
import com.dayuxiaoyu.dashboard.web.response.cms.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewTagService {
    @Resource
    private NewTagDao newTagDao;

    public AddNewTagResponse add(AddNewTagRequest addNewTagRequest) {
        
        NewTagModel newTagModel= new NewTagModel();
        newTagModel.setNewId(addNewTagRequest.getNewId());
        newTagModel.setTagId(addNewTagRequest.getTagId());
        
        NewTagModel result = this.insert(newTagModel);
        
        AddNewTagResponse addNewTagResponse = new AddNewTagResponse(ResultEnum.success);
        addNewTagResponse.setData(result);
        return addNewTagResponse;
    }

    public BatchDeleteNewTagResponse batchDelete(BatchDeleteNewTagRequest batchDeleteNewTagRequest) {
        Boolean result = this.deleteByIds(batchDeleteNewTagRequest.getInIdList());
        BatchDeleteNewTagResponse batchDeleteNewTagResponse = new BatchDeleteNewTagResponse(ResultEnum.success);
        batchDeleteNewTagResponse.setData(result);
        return batchDeleteNewTagResponse;
    }

    public DeleteNewTagResponse delete(DeleteNewTagRequest deleteNewTagRequest) {
        Boolean result = this.deleteByPrimaryKey(deleteNewTagRequest.getId());
        DeleteNewTagResponse deleteNewTagResponse = new DeleteNewTagResponse(ResultEnum.success);
        deleteNewTagResponse.setData(result);
        return deleteNewTagResponse;
    }

    public NewTagDetailResponse detail(NewTagDetailRequest newTagDetailRequest) {
        NewTagModel result = this.selectByPrimaryKey(newTagDetailRequest.getId());
        NewTagDetailResponse newTagDetailResponse = new NewTagDetailResponse(ResultEnum.success);
        newTagDetailResponse.setData(result);
        return newTagDetailResponse;
    }

    public EditNewTagResponse edit(EditNewTagRequest editNewTagRequest) {
        
        NewTagModel newTagModel= new NewTagModel();
        newTagModel.setNewId(editNewTagRequest.getNewId());
        newTagModel.setTagId(editNewTagRequest.getTagId());
        newTagModel.setId(editNewTagRequest.getId());
        Boolean result = this.updateByPrimaryKey(newTagModel);
        
        EditNewTagResponse editNewTagResponse = new EditNewTagResponse(ResultEnum.success);
        editNewTagResponse.setData(result);
        return editNewTagResponse;
    }

    public NewTagListResponse search(NewTagListRequest newTagListRequest) {
        return null;
    }

    public NewTagPageListResponse searchWithPage(NewTagPageListRequest newTagPageListRequest) {
        return null;
    }

    public NewTagModel insert(NewTagModel newTagModel) {
        return newTagDao.addEntity(newTagModel);
    }

    public List<NewTagModel> insertList(List<NewTagModel> newTagModelList) {
        List<NewTagModel> answer = new ArrayList<NewTagModel>();
        for(NewTagModel newTagModel : newTagModelList ){
            answer.add(this.insert(newTagModel));
        }
        return answer;
    }

    public Boolean deleteByNewId(Integer newId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("newId",newId);
        return newTagDao.deleteEntity(cond);
    }

    public Boolean deleteByNewIdAndTagId(Integer newId, Integer tagId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("newId",newId);
        cond.put("tagId",tagId);
        return newTagDao.deleteEntity(cond);
    }

    public Boolean deleteByTagId(Integer tagId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("tagId",tagId);
        return newTagDao.deleteEntity(cond);
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return newTagDao.deleteEntity(cond);
    }

    public Boolean deleteByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        return newTagDao.deleteEntity(cond);
    }

    public Boolean updateByNewId(NewTagModel newTagModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("newId",newTagModel.getNewId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("newId",newTagModel.getNewId());
        updateValue.put("tagId",newTagModel.getTagId());
        return newTagDao.updateEntity(cond,updateValue);
    }

    public Boolean updateByNewIdAndTagId(NewTagModel newTagModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("newId",newTagModel.getNewId());
        cond.put("tagId",newTagModel.getTagId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("newId",newTagModel.getNewId());
        updateValue.put("tagId",newTagModel.getTagId());
        return newTagDao.updateEntity(cond,updateValue);
    }

    public Boolean updateByTagId(NewTagModel newTagModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("tagId",newTagModel.getTagId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("newId",newTagModel.getNewId());
        updateValue.put("tagId",newTagModel.getTagId());
        return newTagDao.updateEntity(cond,updateValue);
    }

    public Boolean updateByPrimaryKey(NewTagModel newTagModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",newTagModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("newId",newTagModel.getNewId());
        updateValue.put("tagId",newTagModel.getTagId());
        return newTagDao.updateEntity(cond,updateValue);
    }

    public List<NewTagModel> selectAll() {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = allColumn();
        return newTagDao.findEntityListByCond(cond,output,null);
    }

    public NewTagModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = allColumn();
        return newTagDao.findEntityById(cond,output);
    }

    public NewTagModel selectOneByNewId(Integer newId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("newId",newId);
        Map<String,Object> output = allColumn();
        return newTagDao.findEntityById(cond,output);
    }

    public List<NewTagModel> selectByNewIdAndTagId(Integer newId, Integer tagId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("newId",newId);
        cond.put("tagId",tagId);
        Map<String,Object> output = allColumn();
        return newTagDao.findEntityListByCond(cond,output,null);
    }

    public NewTagModel selectOneByTagId(Integer tagId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("tagId",tagId);
        Map<String,Object> output = allColumn();
        return newTagDao.findEntityById(cond,output);
    }

    public List<NewTagModel> selectByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        Map<String,Object> output = allColumn();
        return newTagDao.findEntityListByCond(cond,output,null);
    }

    public Map<String,Object> allColumn(){
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("newId","1");
        output.put("tagId","1");
        output.put("id","1");
        return output;
    }
}
