package com.dayuxiaoyu.dashboard.service.cms;

import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.ImageDao;
import com.dayuxiaoyu.dashboard.dao.pagination.PaginationInfo;
import com.dayuxiaoyu.dashboard.dao.pagination.PaginationList;
import com.dayuxiaoyu.dashboard.model.cms.ImageModel;
import com.dayuxiaoyu.dashboard.web.request.cms.AddImageRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.EditImageRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.ImagePageListRequest;
import com.dayuxiaoyu.dashboard.web.response.BaseListResponse;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImageService {
    @Resource
    private ImageDao imageDao;


    public BaseResponse add(AddImageRequest request) {
        
        ImageModel imageModel= new ImageModel();
        imageModel.setName(request.getName());
        imageModel.setUrl(request.getUrl());
        imageModel.setCategoryId(request.getCategoryId());
        imageModel.setType(request.getType());
        imageModel.setSize(request.getSize());

        ImageModel result = this.insert(imageModel);

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

    public BaseResponse edit(EditImageRequest request) {
        
        ImageModel imageModel= new ImageModel();
        imageModel.setName(request.getName());
        imageModel.setId(request.getId());
        imageModel.setCategoryId(request.getCategoryId());

        Boolean result = this.updateByPrimaryKey(imageModel);

        BaseResponse response = new BaseResponse(ResultEnum.success);
        response.setData(result);
        return response;
    }

    public BaseListResponse search(ImagePageListRequest request) {
        BaseListResponse response = new BaseListResponse(ResultEnum.success);
        PaginationList<ImageModel> list = this.selectAllByCategoryId(request.getCategoryId(),request.getPageSize(),request.getPageNo());
        response.setList(list);
        response.setTotalRecord(list.getTotalRecord());
        return response;
    }

    public ImageModel insert(ImageModel imageModel) {
        return imageDao.addEntity(imageModel);
    }

    public List<ImageModel> insertList(List<ImageModel> imageModelList) {
        List<ImageModel> answer = new ArrayList<ImageModel>();
        for(ImageModel imageModel : imageModelList ){
            answer.add(this.insert(imageModel));
        }
        return answer;
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return imageDao.deleteEntity(cond);
    }

    public Boolean updateByPrimaryKey(ImageModel imageModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",imageModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("name",imageModel.getName());
        updateValue.put("createTime",imageModel.getCreateTime());
        updateValue.put("url",imageModel.getUrl());
        updateValue.put("categoryId",imageModel.getCategoryId());
        updateValue.put("type",imageModel.getType());
        updateValue.put("size",imageModel.getSize());
        return imageDao.updateEntity(cond,updateValue);
    }

    public List<ImageModel> selectAll() {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("name","1");
        output.put("createTime","1");
        output.put("id","1");
        output.put("categoryId","1");
        output.put("url","1");
        output.put("size","1");
        output.put("type","1");
        return imageDao.findEntityListByCond(cond,output,null);
    }


    public PaginationList<ImageModel> selectAllByCategoryId(Integer categoryId, Integer pageSize, Integer pageNo) {
        Map<String,Object> cond = new HashMap<String,Object>();
        if(categoryId!=null){
            cond.put("categoryId",categoryId);
        }
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("name","1");
        output.put("createTime","1");
        output.put("id","1");
        output.put("categoryId","1");
        output.put("url","1");
        output.put("size","1");
        output.put("type","1");
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setRecordPerPage(pageSize);
        paginationInfo.setCurrentPage(pageNo);
        return imageDao.findEntityListByCond(cond,output,paginationInfo);
    }

    public ImageModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("name","1");
        output.put("createTime","1");
        output.put("id","1");
        output.put("categoryId","1");
        output.put("url","1");
        output.put("size","1");
        output.put("type","1");
        return imageDao.findEntityById(cond,output);
    }
}
