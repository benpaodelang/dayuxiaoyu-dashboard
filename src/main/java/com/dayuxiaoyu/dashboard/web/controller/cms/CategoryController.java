package com.dayuxiaoyu.dashboard.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.service.cms.CategoryService;
import com.dayuxiaoyu.dashboard.util.ValidationResult;
import com.dayuxiaoyu.dashboard.web.request.cms.AddCategoryRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.BatchDeleteCategoryRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.DeleteCategoryRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.EditCategoryRequest;
import com.dayuxiaoyu.dashboard.web.response.BaseListResponse;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/dayu/category")
@Controller
public class CategoryController {
    @Resource
    public CategoryService categoryService;

    @RequestMapping("order")
    @ResponseBody
    public String order(Integer id,Integer orderNum) {
        BaseResponse response = null;
        try {
            response = categoryService.order(id,orderNum);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(AddCategoryRequest addCategoryRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = addCategoryRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = categoryService.add(addCategoryRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(DeleteCategoryRequest deleteCategoryRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = deleteCategoryRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = categoryService.delete(deleteCategoryRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("batchDelete")
    @ResponseBody
    public String batchDelete(BatchDeleteCategoryRequest batchDeleteCategoryRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = batchDeleteCategoryRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = categoryService.batchDelete(batchDeleteCategoryRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit(EditCategoryRequest editCategoryRequest) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = editCategoryRequest.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = categoryService.edit(editCategoryRequest);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(Integer id) {
        BaseResponse response = null;
        try {
            response = categoryService.detail(id);
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
            response = categoryService.search();
        } catch (Exception e){
            response = new BaseListResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }
}
