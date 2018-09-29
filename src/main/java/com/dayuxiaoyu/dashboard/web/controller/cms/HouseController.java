package com.dayuxiaoyu.dashboard.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.service.cms.HouseService;
import com.dayuxiaoyu.dashboard.util.ValidationResult;
import com.dayuxiaoyu.dashboard.web.request.cms.*;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/dayu/house")
@Controller
public class HouseController {
    @Resource
    public HouseService houseService;

    @RequestMapping("up")
    @ResponseBody
    public String up(Integer id) {
        BaseResponse response = null;
        try {
            response = houseService.up(id);
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
            response = houseService.down(id);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(AddHouseRequest addHouseRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = addHouseRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = houseService.add(addHouseRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(DeleteHouseRequest deleteHouseRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = deleteHouseRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = houseService.delete(deleteHouseRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("batchDelete")
    @ResponseBody
    public String batchDelete(BatchDeleteHouseRequest batchDeleteHouseRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = batchDeleteHouseRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = houseService.batchDelete(batchDeleteHouseRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit(EditHouseRequest editHouseRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = editHouseRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = houseService.edit(editHouseRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(HouseDetailRequest houseDetailRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = houseDetailRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = houseService.detail(houseDetailRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("pageList")
    @ResponseBody
    public String pageList(HousePageListRequest housePageListRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = housePageListRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = houseService.searchWithPage(housePageListRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("query")
    @ResponseBody
    public String query(String query) {
        BaseResponse response = null;
        try {
            response = houseService.query(query);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }
}
