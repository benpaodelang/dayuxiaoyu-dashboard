package com.dayuxiaoyu.dashboard.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.service.cms.TagService;
import com.dayuxiaoyu.dashboard.util.ValidationResult;
import com.dayuxiaoyu.dashboard.web.request.cms.AddTagRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.EditTagRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.TagDetailRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.TagListRequest;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/dayu/tag")
@Controller
public class TagController {
    @Resource
    public TagService tagService;

    @RequestMapping("add")
    @ResponseBody
    public String add(AddTagRequest addTagRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = addTagRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = tagService.add(addTagRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit(EditTagRequest editTagRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = editTagRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = tagService.edit(editTagRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(TagListRequest tagListRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = tagListRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = tagService.search(tagListRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(TagDetailRequest tagDetailRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = tagDetailRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = tagService.detail(tagDetailRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }
}
