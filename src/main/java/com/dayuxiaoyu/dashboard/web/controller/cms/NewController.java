package com.dayuxiaoyu.dashboard.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.service.cms.NewService;
import com.dayuxiaoyu.dashboard.util.ValidationResult;
import com.dayuxiaoyu.dashboard.web.request.cms.*;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/dayu/new")
@Controller
public class NewController {
    @Resource
    public NewService newService;

    @RequestMapping("up")
    @ResponseBody
    public String up(Integer id) {
        BaseResponse response = null;
        try {
            response = newService.up(id);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("down")
    @ResponseBody
    public String down(Integer id) {
        BaseResponse response = null;
        try {
            response = newService.down(id);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(AddNewRequest addNewRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = addNewRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = newService.add(addNewRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(NewDetailRequest request){
        BaseResponse response = null;
        try {
            ValidationResult validateResult = request.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = newService.detail(request);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(DeleteNewRequest deleteNewRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = deleteNewRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = newService.delete(deleteNewRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("batchDelete")
    @ResponseBody
    public String batchDelete(BatchDeleteNewRequest batchDeleteNewRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = batchDeleteNewRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = newService.batchDelete(batchDeleteNewRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit(EditNewRequest editNewRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = editNewRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = newService.edit(editNewRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("pageList")
    @ResponseBody
    public String pageList(NewPageListRequest newPageListRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = newPageListRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = newService.searchWithPage(newPageListRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }
}
