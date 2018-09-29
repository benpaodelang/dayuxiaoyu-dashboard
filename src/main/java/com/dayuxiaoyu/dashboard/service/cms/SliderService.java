package com.dayuxiaoyu.dashboard.service.cms;

import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.SliderDao;
import com.dayuxiaoyu.dashboard.model.cms.SliderModel;
import com.dayuxiaoyu.dashboard.web.request.cms.*;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import com.dayuxiaoyu.dashboard.web.response.cms.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SliderService {
    @Resource
    private SliderDao sliderDao;

    public BaseResponse order(Integer id, Integer orderNum){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        SliderModel sliderModel = new SliderModel();
        sliderModel.setId(id);
        sliderModel.setOrderNum(orderNum);
        this.updateByPrimaryKey(sliderModel);
        return response;
    }

    public AddSliderResponse add(AddSliderRequest addSliderRequest) {
        
        SliderModel sliderModel= new SliderModel();
        sliderModel.setImage(addSliderRequest.getImage());
        sliderModel.setTitle(addSliderRequest.getTitle());
        sliderModel.setPositionId(addSliderRequest.getPositionId());
        sliderModel.setUrl(addSliderRequest.getUrl());
        sliderModel.setOrderNum(addSliderRequest.getOrderNum());
        
        SliderModel result = this.insert(sliderModel);
        
        AddSliderResponse addSliderResponse = new AddSliderResponse(ResultEnum.success);
        addSliderResponse.setData(result);
        return addSliderResponse;
    }

    public DeleteSliderResponse delete(DeleteSliderRequest deleteSliderRequest) {
        Boolean result = this.deleteByPrimaryKey(deleteSliderRequest.getId());
        DeleteSliderResponse deleteSliderResponse = new DeleteSliderResponse(ResultEnum.success);
        deleteSliderResponse.setData(result);
        return deleteSliderResponse;
    }

    public SliderDetailResponse detail(SliderDetailRequest sliderDetailRequest) {
        SliderModel result = this.selectByPrimaryKey(sliderDetailRequest.getId());
        SliderDetailResponse sliderDetailResponse = new SliderDetailResponse(ResultEnum.success);
        sliderDetailResponse.setData(result);
        return sliderDetailResponse;
    }

    public EditSliderResponse edit(EditSliderRequest editSliderRequest) {
        
        SliderModel sliderModel= new SliderModel();
        sliderModel.setImage(editSliderRequest.getImage());
        sliderModel.setTitle(editSliderRequest.getTitle());
        sliderModel.setUrl(editSliderRequest.getUrl());
        sliderModel.setOrderNum(editSliderRequest.getOrderNum());
        sliderModel.setId(editSliderRequest.getId());
        Boolean result = this.updateByPrimaryKey(sliderModel);
        
        EditSliderResponse editSliderResponse = new EditSliderResponse(ResultEnum.success);
        editSliderResponse.setData(result);
        return editSliderResponse;
    }

    public SliderListResponse search(SliderListRequest request) {
        SliderListResponse response = new SliderListResponse(ResultEnum.success);
        response.setList(this.selectByPosition(request.getPositionId()));
        return response;
    }

    public SliderModel insert(SliderModel sliderModel) {
        return sliderDao.addEntity(sliderModel);
    }

    public List<SliderModel> insertList(List<SliderModel> sliderModelList) {
        List<SliderModel> answer = new ArrayList<SliderModel>();
        for(SliderModel sliderModel : sliderModelList ){
            answer.add(this.insert(sliderModel));
        }
        return answer;
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return sliderDao.deleteEntity(cond);
    }

    public Boolean updateByPrimaryKey(SliderModel sliderModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",sliderModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("image",sliderModel.getImage());
        updateValue.put("title",sliderModel.getTitle());
        updateValue.put("url",sliderModel.getUrl());
        updateValue.put("positionId",sliderModel.getPositionId());
        updateValue.put("orderNum",sliderModel.getOrderNum());
        return sliderDao.updateEntity(cond,updateValue);
    }

    public List<SliderModel> selectByPosition(Integer position) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("positionId",position);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("image","1");
        output.put("title","1");
        output.put("url","1");
        output.put("orderNum","1");
        output.put("positionId","1");
        output.put("id","1");
        return sliderDao.findEntityListByCond(cond,output,null);
    }

    public List<SliderModel> selectAll() {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("image","1");
        output.put("title","1");
        output.put("url","1");
        output.put("orderNum","1");
        output.put("positionId","1");
        output.put("id","1");
        return sliderDao.findEntityListByCond(cond,output,null);
    }

    public SliderModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("image","1");
        output.put("title","1");
        output.put("url","1");
        output.put("orderNum","1");
        output.put("positionId","1");
        output.put("id","1");
        return sliderDao.findEntityById(cond,output);
    }
}
