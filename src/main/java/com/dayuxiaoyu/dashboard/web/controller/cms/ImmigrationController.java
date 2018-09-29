package com.dayuxiaoyu.dashboard.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.service.cms.ImmigrationService;
import com.dayuxiaoyu.dashboard.util.ValidationResult;
import com.dayuxiaoyu.dashboard.web.request.cms.*;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/dayu/immigration")
@Controller
public class ImmigrationController {
    @Resource
    public ImmigrationService immigrationService;

    @RequestMapping("up")
    @ResponseBody
    public String up(Integer id) {
        BaseResponse response = null;
        try {
            response = immigrationService.up(id);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("order")
    @ResponseBody
    public String order(Integer id,Integer orderNum) {
        BaseResponse response = null;
        try {
            response = immigrationService.order(id,orderNum);
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
            response = immigrationService.down(id);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(AddImmigrationRequest addImmigrationRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = addImmigrationRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = immigrationService.add(addImmigrationRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(DeleteImmigrationRequest deleteImmigrationRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = deleteImmigrationRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = immigrationService.delete(deleteImmigrationRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("batchDelete")
    @ResponseBody
    public String batchDelete(BatchDeleteImmigrationRequest batchDeleteImmigrationRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = batchDeleteImmigrationRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = immigrationService.batchDelete(batchDeleteImmigrationRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit(EditImmigrationRequest editImmigrationRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = editImmigrationRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = immigrationService.edit(editImmigrationRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("pageList")
    @ResponseBody
    public String list(ImmigrationPageListRequest request) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = request.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = immigrationService.searchWithPage(request);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(ImmigrationDetailRequest immigrationDetailRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = immigrationDetailRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = immigrationService.detail(immigrationDetailRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }
}
