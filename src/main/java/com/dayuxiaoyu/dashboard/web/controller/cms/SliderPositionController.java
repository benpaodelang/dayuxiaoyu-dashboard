package com.dayuxiaoyu.dashboard.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.service.cms.SliderPositionService;
import com.dayuxiaoyu.dashboard.util.ValidationResult;
import com.dayuxiaoyu.dashboard.web.request.cms.AddSliderPositionRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.DeleteSliderPositionRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.EditSliderPositionRequest;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("dayu/sliderPosition")
@Controller
public class SliderPositionController {
    @Resource
    public SliderPositionService sliderPositionService;

    @RequestMapping("add")
    @ResponseBody
    public String add(AddSliderPositionRequest addSliderPositionRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = addSliderPositionRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = sliderPositionService.add(addSliderPositionRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(DeleteSliderPositionRequest deleteSliderPositionRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = deleteSliderPositionRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = sliderPositionService.delete(deleteSliderPositionRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit(EditSliderPositionRequest editSliderPositionRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = editSliderPositionRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = sliderPositionService.edit(editSliderPositionRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("list")
    @ResponseBody
    public String list() {
        BaseResponse response = null;
        try {
            response = sliderPositionService.search();
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }
}
