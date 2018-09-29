package com.dayuxiaoyu.dashboard.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.service.cms.RecommendService;
import com.dayuxiaoyu.dashboard.util.ValidationResult;
import com.dayuxiaoyu.dashboard.web.request.cms.*;
import com.dayuxiaoyu.dashboard.web.response.BaseListResponse;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("dayu/recommend")
@Controller
public class RecommendController {
    @Resource
    public RecommendService recommendService;

    @RequestMapping("order")
    @ResponseBody
    public String order(Integer id,Integer orderNum) {
        BaseResponse response = null;
        try {
            response = recommendService.order(id,orderNum);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(AddRecommendRequest addRecommendRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = addRecommendRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = recommendService.add(addRecommendRequest);
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
            response = recommendService.delete(id);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit(EditRecommendRequest editRecommendRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = editRecommendRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = recommendService.edit(editRecommendRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(Integer positionId) {
        BaseResponse response = null;
        try {
            response = recommendService.search(positionId);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("positionList")
    @ResponseBody
    public String positionList(Integer id,String type) {
        BaseListResponse response = null;
        try {
            response = recommendService.positionList(id,type);
        } catch (Exception e){
            response = new BaseListResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("recommend")
    @ResponseBody
    public String recommend(RecommendRequest request) {
        BaseResponse response = null;
        try {
            response = recommendService.recommend(request);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }
}
