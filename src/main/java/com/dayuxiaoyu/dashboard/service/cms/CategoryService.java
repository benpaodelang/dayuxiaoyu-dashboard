package com.dayuxiaoyu.dashboard.service.cms;

import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.CategoryDao;
import com.dayuxiaoyu.dashboard.model.cms.CategoryModel;
import com.dayuxiaoyu.dashboard.web.request.cms.*;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import com.dayuxiaoyu.dashboard.web.response.cms.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Resource
    private CategoryDao categoryDao;

    public BaseResponse order(Integer id, Integer orderNum){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(id);
        categoryModel.setOrderNum(orderNum);
        this.updateByPrimaryKey(categoryModel);
        return response;
    }

    public AddCategoryResponse add(AddCategoryRequest addCategoryRequest) {
        
        CategoryModel categoryModel= new CategoryModel();
        categoryModel.setName(addCategoryRequest.getName());
        categoryModel.setType(addCategoryRequest.getType());
        
        CategoryModel result = this.insert(categoryModel);
        
        AddCategoryResponse addCategoryResponse = new AddCategoryResponse(ResultEnum.success);
        addCategoryResponse.setData(result);
        return addCategoryResponse;
    }

    public BatchDeleteCategoryResponse batchDelete(BatchDeleteCategoryRequest batchDeleteCategoryRequest) {
        Boolean result = this.deleteByIds(batchDeleteCategoryRequest.getInIdList());
        BatchDeleteCategoryResponse batchDeleteCategoryResponse = new BatchDeleteCategoryResponse(ResultEnum.success);
        batchDeleteCategoryResponse.setData(result);
        return batchDeleteCategoryResponse;
    }

    public DeleteCategoryResponse delete(DeleteCategoryRequest deleteCategoryRequest) {
        Boolean result = this.deleteByPrimaryKey(deleteCategoryRequest.getId());
        DeleteCategoryResponse deleteCategoryResponse = new DeleteCategoryResponse(ResultEnum.success);
        deleteCategoryResponse.setData(result);
        return deleteCategoryResponse;
    }

    public BaseResponse detail(Integer id) {
        CategoryModel result = this.selectByPrimaryKey(id);
        BaseResponse response = new BaseResponse(ResultEnum.success);
        response.setData(result);
        return response;
    }

    public EditCategoryResponse edit(EditCategoryRequest editCategoryRequest) {
        
        CategoryModel categoryModel= new CategoryModel();
        categoryModel.setName(editCategoryRequest.getName());
        categoryModel.setId(editCategoryRequest.getId());
        categoryModel.setContent(editCategoryRequest.getContent());
        Boolean result = this.updateByPrimaryKey(categoryModel);
        
        EditCategoryResponse editCategoryResponse = new EditCategoryResponse(ResultEnum.success);
        editCategoryResponse.setData(result);
        return editCategoryResponse;
    }

    public CategoryListResponse search() {
        CategoryListResponse response = new CategoryListResponse(ResultEnum.success);
        response.setList(this.selectAll());
        return response;
    }

    public CategoryPageListResponse searchWithPage(CategoryPageListRequest categoryPageListRequest) {
        return null;
    }


    public List<CategoryModel> categoryTree(){
        return this.buildTree(0);
    }

    public List<CategoryModel> buildTree(Integer parentId){
        List<CategoryModel> categorys = this.selectByParentId(parentId);
        for (CategoryModel category : categorys){
            category.setChildren(this.buildTree(category.getId()));
        }
        return categorys;
    }

    public CategoryModel insert(CategoryModel categoryModel) {
        return categoryDao.addEntity(categoryModel);
    }

    public List<CategoryModel> insertList(List<CategoryModel> categoryModelList) {
        List<CategoryModel> answer = new ArrayList<CategoryModel>();
        for(CategoryModel categoryModel : categoryModelList ){
            answer.add(this.insert(categoryModel));
        }
        return answer;
    }

    public Boolean deleteByParentId(Integer parentId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("parentId",parentId);
        return categoryDao.deleteEntity(cond);
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return categoryDao.deleteEntity(cond);
    }

    public Boolean deleteByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        return categoryDao.deleteEntity(cond);
    }

    public Boolean updateByParentId(CategoryModel categoryModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("parentId",categoryModel.getParentId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("parentId",categoryModel.getParentId());
        updateValue.put("name",categoryModel.getName());
        updateValue.put("icon",categoryModel.getIcon());
        updateValue.put("type",categoryModel.getType());
        updateValue.put("display",categoryModel.getDisplay());
        updateValue.put("path",categoryModel.getPath());
        updateValue.put("createTime",categoryModel.getCreateTime());
        updateValue.put("updateTime",categoryModel.getUpdateTime());
        updateValue.put("orderNum",categoryModel.getOrderNum());
        updateValue.put("content",categoryModel.getContent());
        return categoryDao.updateEntity(cond,updateValue);
    }

    public Boolean updateByPrimaryKey(CategoryModel categoryModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",categoryModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("parentId",categoryModel.getParentId());
        updateValue.put("name",categoryModel.getName());
        updateValue.put("icon",categoryModel.getIcon());
        updateValue.put("type",categoryModel.getType());
        updateValue.put("display",categoryModel.getDisplay());
        updateValue.put("path",categoryModel.getPath());
        updateValue.put("createTime",categoryModel.getCreateTime());
        updateValue.put("updateTime",categoryModel.getUpdateTime());
        updateValue.put("orderNum",categoryModel.getOrderNum());
        updateValue.put("content",categoryModel.getContent());
        return categoryDao.updateEntity(cond,updateValue);
    }

    public List<CategoryModel> selectAll() {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = this.allColumn();
        return categoryDao.findEntityListByCond(cond,output,null);
    }

    public CategoryModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = this.allColumn();
        return categoryDao.findEntityById(cond,output);
    }

    public List<CategoryModel> selectByParentId(Integer parentId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("parentId",parentId);
        Map<String,Object> output = this.allColumn();
        return categoryDao.findEntityListByCond(cond,output,null);
    }

    public List<CategoryModel> selectByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        Map<String,Object> output = this.allColumn();
        return categoryDao.findEntityListByCond(cond,output,null);
    }

    public Map<String,Object> allColumn(){
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("parentId","1");
        output.put("name","1");
        output.put("icon","1");
        output.put("type","1");
        output.put("display","1");
        output.put("path","1");
        output.put("createTime","1");
        output.put("content","1");
        output.put("updateTime","1");
        output.put("orderNum","1");
        output.put("id","1");
        return output;
    }
}
