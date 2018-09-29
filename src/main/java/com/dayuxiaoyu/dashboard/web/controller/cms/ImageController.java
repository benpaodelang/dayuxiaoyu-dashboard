package com.dayuxiaoyu.dashboard.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.service.cms.ImageService;
import com.dayuxiaoyu.dashboard.util.ValidationResult;
import com.dayuxiaoyu.dashboard.web.request.cms.*;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("dayu/image")
@Controller
public class ImageController {
    @Resource
    public ImageService imageService;

    @RequestMapping("add")
    @ResponseBody
    public String add(AddImageRequest addImageRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = addImageRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = imageService.add(addImageRequest);
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
            response = imageService.delete(id);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }


    @RequestMapping("edit")
    @ResponseBody
    public String edit(EditImageRequest editImageRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = editImageRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = imageService.edit(editImageRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }


    @RequestMapping("pageList")
    @ResponseBody
    public String pageList(ImagePageListRequest imagePageListRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = imagePageListRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = imageService.search(imagePageListRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }
}
