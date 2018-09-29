package com.dayuxiaoyu.dashboard.service.cms;

import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.NewDao;
import com.dayuxiaoyu.dashboard.dao.pagination.PaginationInfo;
import com.dayuxiaoyu.dashboard.dao.pagination.PaginationList;
import com.dayuxiaoyu.dashboard.model.cms.NewModel;
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
public class NewService {
    @Resource
    private NewDao newDao;

    public BaseResponse up(Integer id){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        NewModel newModel = new NewModel();
        newModel.setId(id);
        newModel.setStatus(1);
        this.updateByPrimaryKey(newModel);
        return response;
    }

    public BaseResponse down(Integer id){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        NewModel newModel = new NewModel();
        newModel.setId(id);
        newModel.setStatus(0);
        this.updateByPrimaryKey(newModel);
        return response;
    }

    public AddNewResponse add(AddNewRequest addNewRequest) {
        
        NewModel newModel= new NewModel();
        newModel.setTitle(addNewRequest.getTitle());
        newModel.setDescription(addNewRequest.getDescription());
        newModel.setThumbnail(addNewRequest.getThumbnail());
        newModel.setContent(addNewRequest.getContent());
        
        NewModel result = this.insert(newModel);
        
        AddNewResponse addNewResponse = new AddNewResponse(ResultEnum.success);
        addNewResponse.setData(result);
        return addNewResponse;
    }

    public BatchDeleteNewResponse batchDelete(BatchDeleteNewRequest batchDeleteNewRequest) {
        Boolean result = this.deleteByIds(batchDeleteNewRequest.getInIdList());
        BatchDeleteNewResponse batchDeleteNewResponse = new BatchDeleteNewResponse(ResultEnum.success);
        batchDeleteNewResponse.setData(result);
        return batchDeleteNewResponse;
    }

    public DeleteNewResponse delete(DeleteNewRequest deleteNewRequest) {
        Boolean result = this.deleteByPrimaryKey(deleteNewRequest.getId());
        DeleteNewResponse deleteNewResponse = new DeleteNewResponse(ResultEnum.success);
        deleteNewResponse.setData(result);
        return deleteNewResponse;
    }

    public NewDetailResponse detail(NewDetailRequest newDetailRequest) {
        NewModel result = this.selectByPrimaryKey(newDetailRequest.getId());
        NewDetailResponse newDetailResponse = new NewDetailResponse(ResultEnum.success);
        newDetailResponse.setData(result);
        return newDetailResponse;
    }

    public EditNewResponse edit(EditNewRequest editNewRequest) {
        
        NewModel newModel= new NewModel();
        newModel.setTitle(editNewRequest.getTitle());
        newModel.setDescription(editNewRequest.getDescription());
        newModel.setContent(editNewRequest.getContent());
        newModel.setId(editNewRequest.getId());
        newModel.setThumbnail(editNewRequest.getThumbnail());
        Boolean result = this.updateByPrimaryKey(newModel);
        
        EditNewResponse editNewResponse = new EditNewResponse(ResultEnum.success);
        editNewResponse.setData(result);
        return editNewResponse;
    }

    public NewListResponse search(NewListRequest newListRequest) {
        return null;
    }

    public NewPageListResponse searchWithPage(NewPageListRequest request) {
        NewPageListResponse response = new NewPageListResponse(ResultEnum.success);
        PaginationList<NewModel> list = this.selectByPage(request.getPageSize(),request.getPageNo());
        response.setList(list);
        response.setTotalPage(list.getTotalPage());
        response.setTotalRecord(list.getTotalRecord());
        return response;
    }

    public NewModel insert(NewModel newModel) {
        return newDao.addEntity(newModel);
    }

    public List<NewModel> insertList(List<NewModel> newModelList) {
        List<NewModel> answer = new ArrayList<NewModel>();
        for(NewModel newModel : newModelList ){
            answer.add(this.insert(newModel));
        }
        return answer;
    }

    public Boolean deleteByCategoryId(Integer categoryId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("categoryId",categoryId);
        return newDao.deleteEntity(cond);
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return newDao.deleteEntity(cond);
    }

    public Boolean deleteByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        return newDao.deleteEntity(cond);
    }

    public Boolean updateByCategoryId(NewModel newModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("categoryId",newModel.getCategoryId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("title",newModel.getTitle());
        updateValue.put("createTime",newModel.getCreateTime());
        updateValue.put("description",newModel.getDescription());
        updateValue.put("content",newModel.getContent());
        updateValue.put("categoryId",newModel.getCategoryId());
        updateValue.put("thumbnail",newModel.getThumbnail());
        updateValue.put("status",newModel.getStatus());
        return newDao.updateEntity(cond,updateValue);
    }

    public Boolean updateByPrimaryKey(NewModel newModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",newModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("title",newModel.getTitle());
        updateValue.put("createTime",newModel.getCreateTime());
        updateValue.put("description",newModel.getDescription());
        updateValue.put("content",newModel.getContent());
        updateValue.put("categoryId",newModel.getCategoryId());
        updateValue.put("thumbnail",newModel.getThumbnail());
        updateValue.put("status",newModel.getStatus());
        return newDao.updateEntity(cond,updateValue);
    }

    public NewModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = allColumn();
        return newDao.findEntityById(cond,output);
    }

    public PaginationList<NewModel> selectByPage(Integer pageSize, Integer pageNo){
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = allColumn();
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setRecordPerPage(pageSize);
        paginationInfo.setCurrentPage(pageNo);
        return newDao.findEntityListByCond(cond,output,paginationInfo);
    }

    public List<NewModel> selectByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        Map<String,Object> output = allColumn();
        return newDao.findEntityListByCond(cond,output,null);
    }

    public Map<String,Object> allColumn(){
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("title","1");
        output.put("createTime","1");
        output.put("description","1");
        output.put("content","1");
        output.put("categoryId","1");
        output.put("thumbnail","1");
        output.put("status","1");
        output.put("id","1");
        return output;
    }
}
