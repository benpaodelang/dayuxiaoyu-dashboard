package com.dayuxiaoyu.dashboard.service.cms;

import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.SliderPositionDao;
import com.dayuxiaoyu.dashboard.model.cms.SliderPositionModel;
import com.dayuxiaoyu.dashboard.web.request.cms.*;
import com.dayuxiaoyu.dashboard.web.response.cms.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SliderPositionService {
    @Resource
    private SliderPositionDao sliderPositionDao;

    public AddSliderPositionResponse add(AddSliderPositionRequest addSliderPositionRequest) {
        
        SliderPositionModel sliderPositionModel= new SliderPositionModel();
        sliderPositionModel.setName(addSliderPositionRequest.getName());
        
        SliderPositionModel result = this.insert(sliderPositionModel);
        
        AddSliderPositionResponse addSliderPositionResponse = new AddSliderPositionResponse(ResultEnum.success);
        addSliderPositionResponse.setData(result);
        return addSliderPositionResponse;
    }

    public DeleteSliderPositionResponse delete(DeleteSliderPositionRequest deleteSliderPositionRequest) {
        Boolean result = this.deleteByPrimaryKey(deleteSliderPositionRequest.getId());
        DeleteSliderPositionResponse deleteSliderPositionResponse = new DeleteSliderPositionResponse(ResultEnum.success);
        deleteSliderPositionResponse.setData(result);
        return deleteSliderPositionResponse;
    }

    public SliderPositionDetailResponse detail(SliderPositionDetailRequest sliderPositionDetailRequest) {
        SliderPositionModel result = this.selectByPrimaryKey(sliderPositionDetailRequest.getId());
        SliderPositionDetailResponse sliderPositionDetailResponse = new SliderPositionDetailResponse(ResultEnum.success);
        sliderPositionDetailResponse.setData(result);
        return sliderPositionDetailResponse;
    }

    public EditSliderPositionResponse edit(EditSliderPositionRequest editSliderPositionRequest) {
        
        SliderPositionModel sliderPositionModel= new SliderPositionModel();
        sliderPositionModel.setName(editSliderPositionRequest.getName());
        sliderPositionModel.setId(editSliderPositionRequest.getId());
        Boolean result = this.updateByPrimaryKey(sliderPositionModel);
        
        EditSliderPositionResponse editSliderPositionResponse = new EditSliderPositionResponse(ResultEnum.success);
        editSliderPositionResponse.setData(result);
        return editSliderPositionResponse;
    }

    public SliderPositionListResponse search() {
        SliderPositionListResponse response = new SliderPositionListResponse(ResultEnum.success);
        response.setList(this.selectAll());
        return response;
    }

    public SliderPositionPageListResponse searchWithPage(SliderPositionPageListRequest sliderPositionPageListRequest) {
        return null;
    }

    public SliderPositionModel insert(SliderPositionModel sliderPositionModel) {
        return sliderPositionDao.addEntity(sliderPositionModel);
    }

    public List<SliderPositionModel> insertList(List<SliderPositionModel> sliderPositionModelList) {
        List<SliderPositionModel> answer = new ArrayList<SliderPositionModel>();
        for(SliderPositionModel sliderPositionModel : sliderPositionModelList ){
            answer.add(this.insert(sliderPositionModel));
        }
        return answer;
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return sliderPositionDao.deleteEntity(cond);
    }

    public Boolean updateByPrimaryKey(SliderPositionModel sliderPositionModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",sliderPositionModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("name",sliderPositionModel.getName());
        updateValue.put("createTime",sliderPositionModel.getCreateTime());
        return sliderPositionDao.updateEntity(cond,updateValue);
    }

    public List<SliderPositionModel> selectAll() {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("name","1");
        output.put("createTime","1");
        output.put("id","1");
        return sliderPositionDao.findEntityListByCond(cond,output,null);
    }

    public SliderPositionModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("name","1");
        output.put("createTime","1");
        output.put("id","1");
        return sliderPositionDao.findEntityById(cond,output);
    }
}
