package com.dayuxiaoyu.dashboard.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.service.cms.ImageGroupService;
import com.dayuxiaoyu.dashboard.util.ValidationResult;
import com.dayuxiaoyu.dashboard.web.request.cms.AddImageGroupRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.EditImageGroupRequest;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("dayu/imageGroup")
@Controller
public class ImageGroupController {
    @Resource
    public ImageGroupService imageGroupService;

    @RequestMapping("add")
    @ResponseBody
    public String add(AddImageGroupRequest addImageGroupRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = addImageGroupRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = imageGroupService.add(addImageGroupRequest);
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
            response = imageGroupService.delete(id);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit(EditImageGroupRequest editImageGroupRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = editImageGroupRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = imageGroupService.edit(editImageGroupRequest);
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
            response = imageGroupService.search();
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }
}
