package com.dayuxiaoyu.dashboard.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.service.cms.NewTagService;
import com.dayuxiaoyu.dashboard.util.ValidationResult;
import com.dayuxiaoyu.dashboard.web.request.cms.AddNewTagRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.EditNewTagRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.NewTagListRequest;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/dayu/newTag")
@Controller
public class NewTagController {
    @Resource
    public NewTagService newTagService;

    @RequestMapping("add")
    @ResponseBody
    public String add(AddNewTagRequest addNewTagRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = addNewTagRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = newTagService.add(addNewTagRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit(EditNewTagRequest editNewTagRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = editNewTagRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = newTagService.edit(editNewTagRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(NewTagListRequest newTagListRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = newTagListRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = newTagService.search(newTagListRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }
}
