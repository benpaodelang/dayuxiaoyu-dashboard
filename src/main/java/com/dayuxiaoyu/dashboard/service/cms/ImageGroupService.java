package com.dayuxiaoyu.dashboard.service.cms;

import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.ImageGroupDao;
import com.dayuxiaoyu.dashboard.model.cms.ImageGroupModel;
import com.dayuxiaoyu.dashboard.web.request.cms.AddImageGroupRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.EditImageGroupRequest;
import com.dayuxiaoyu.dashboard.web.response.BaseListResponse;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImageGroupService {
    @Resource
    private ImageGroupDao imageGroupDao;

    public BaseResponse add(AddImageGroupRequest request) {
        
        ImageGroupModel imageGroupModel= new ImageGroupModel();
        imageGroupModel.setName(request.getName());
        
        ImageGroupModel result = this.insert(imageGroupModel);

        BaseResponse response = new BaseResponse(ResultEnum.success);
        response.setData(result);
        return response;
    }

    public BaseResponse delete(Integer id) {
        Boolean result = this.deleteByPrimaryKey(id);
        BaseResponse response = new BaseResponse(ResultEnum.success);
        response.setData(result);
        return response;
    }

    public BaseResponse edit(EditImageGroupRequest request) {
        
        ImageGroupModel imageGroupModel= new ImageGroupModel();
        imageGroupModel.setName(request.getName());
        imageGroupModel.setId(request.getId());
        Boolean result = this.updateByPrimaryKey(imageGroupModel);

        BaseResponse response = new BaseResponse(ResultEnum.success);
        response.setData(result);
        return response;
    }

    public BaseListResponse search() {
        BaseListResponse response = new BaseListResponse(ResultEnum.success);
        response.setList(this.selectAll());
        return response;
    }

    public ImageGroupModel insert(ImageGroupModel imageGroupModel) {
        return imageGroupDao.addEntity(imageGroupModel);
    }

    public List<ImageGroupModel> insertList(List<ImageGroupModel> imageGroupModelList) {
        List<ImageGroupModel> answer = new ArrayList<ImageGroupModel>();
        for(ImageGroupModel imageGroupModel : imageGroupModelList ){
            answer.add(this.insert(imageGroupModel));
        }
        return answer;
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return imageGroupDao.deleteEntity(cond);
    }

    public Boolean updateByPrimaryKey(ImageGroupModel imageGroupModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",imageGroupModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("name",imageGroupModel.getName());
        updateValue.put("createTime",imageGroupModel.getCreateTime());
        return imageGroupDao.updateEntity(cond,updateValue);
    }


    public List<ImageGroupModel> selectAll() {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("name","1");
        output.put("createTime","1");
        output.put("id","1");
        return imageGroupDao.findEntityListByCond(cond,output,null);
    }

    public ImageGroupModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("name","1");
        output.put("createTime","1");
        output.put("id","1");
        return imageGroupDao.findEntityById(cond,output);
    }
}
