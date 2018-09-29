package com.dayuxiaoyu.dashboard.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.service.cms.RecommendPositionService;
import com.dayuxiaoyu.dashboard.util.ValidationResult;
import com.dayuxiaoyu.dashboard.web.request.cms.AddRecommendPositionRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.EditRecommendPositionRequest;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("dayu/recommendPosition")
@Controller
public class RecommendPositionController {
    @Resource
    public RecommendPositionService recommendPositionService;

    @RequestMapping("add")
    @ResponseBody
    public String add(AddRecommendPositionRequest addRecommendPositionRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = addRecommendPositionRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = recommendPositionService.add(addRecommendPositionRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(Integer id) {
        BaseResponse response = null;
        try {
            response = recommendPositionService.delete(id);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit(EditRecommendPositionRequest editRecommendPositionRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = editRecommendPositionRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = recommendPositionService.edit(editRecommendPositionRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(String type) {
        BaseResponse response = null;
        try {
            response = recommendPositionService.search(type);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }
}
