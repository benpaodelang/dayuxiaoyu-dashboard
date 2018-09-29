package com.dayuxiaoyu.dashboard.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.service.cms.CountryService;
import com.dayuxiaoyu.dashboard.util.ValidationResult;
import com.dayuxiaoyu.dashboard.web.request.cms.AddCountryRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.EditCountryRequest;
import com.dayuxiaoyu.dashboard.web.response.BaseListResponse;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/dayu/country")
@Controller
public class CountryController {
    @Resource
    public CountryService countryService;

    @RequestMapping("order")
    @ResponseBody
    public String order(Integer id,Integer orderNum) {
        BaseResponse response = null;
        try {
            response = countryService.order(id,orderNum);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }


    @RequestMapping("add")
    @ResponseBody
    public String add(AddCountryRequest addCountryRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = addCountryRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = countryService.add(addCountryRequest);
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
            response = countryService.delete(id);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit(EditCountryRequest editCountryRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = editCountryRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = countryService.edit(editCountryRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("list")
    @ResponseBody
    public String list() {
        BaseListResponse response = null;
        try {
            response = countryService.search();
        } catch (Exception e){
            response = new BaseListResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }
}
