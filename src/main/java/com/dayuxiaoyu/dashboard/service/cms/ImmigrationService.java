package com.dayuxiaoyu.dashboard.service.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.ImmigrationDao;
import com.dayuxiaoyu.dashboard.dao.pagination.PaginationInfo;
import com.dayuxiaoyu.dashboard.dao.pagination.PaginationList;
import com.dayuxiaoyu.dashboard.model.cms.ImmigrationModel;
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
public class ImmigrationService {
    @Resource
    private ImmigrationDao immigrationDao;

    public BaseResponse up(Integer id){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        ImmigrationModel immigrationModel = new ImmigrationModel();
        immigrationModel.setId(id);
        immigrationModel.setStatus(1);
        this.updateByPrimaryKey(immigrationModel);
        return response;
    }

    public BaseResponse down(Integer id){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        ImmigrationModel immigrationModel = new ImmigrationModel();
        immigrationModel.setId(id);
        immigrationModel.setStatus(0);
        this.updateByPrimaryKey(immigrationModel);
        return response;
    }

    public BaseResponse order(Integer id,Integer order){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        ImmigrationModel immigrationModel = new ImmigrationModel();
        immigrationModel.setId(id);
        immigrationModel.setOrderNum(order);
        this.updateByPrimaryKey(immigrationModel);
        return response;
    }

    public AddImmigrationResponse add(AddImmigrationRequest addImmigrationRequest) {
        
        ImmigrationModel immigrationModel= new ImmigrationModel();
        immigrationModel.setTitle(addImmigrationRequest.getTitle());
        immigrationModel.setPicture(addImmigrationRequest.getPicture());
        immigrationModel.setPriceDetail(addImmigrationRequest.getPriceDetail());
        immigrationModel.setProjectBenefits(addImmigrationRequest.getProjectBenefits());
        immigrationModel.setApplicationProcess(addImmigrationRequest.getApplicationProcess());
        immigrationModel.setApplicationCondition(addImmigrationRequest.getApplicationCondition());
        immigrationModel.setCountryInstroduction(addImmigrationRequest.getCountryInstroduction());
        immigrationModel.setSuccessCase(addImmigrationRequest.getSuccessCase());
        immigrationModel.setPrice(addImmigrationRequest.getPrice());
        immigrationModel.setPeriod(addImmigrationRequest.getPeriod());
        immigrationModel.setIdentityType(addImmigrationRequest.getIdentityType());
        immigrationModel.setLivingRequirement(addImmigrationRequest.getLivingRequirement());
        immigrationModel.setCriminalRecord(addImmigrationRequest.getCriminalRecord());
        immigrationModel.setVideos(addImmigrationRequest.getVideos());
        immigrationModel.setHouses(addImmigrationRequest.getHouses());
        immigrationModel.setSubTitle(addImmigrationRequest.getSubTitle());
        immigrationModel.setCountry(addImmigrationRequest.getCountry());
        immigrationModel.setDescription(addImmigrationRequest.getDescription());
        
        ImmigrationModel result = this.insert(immigrationModel);
        
        AddImmigrationResponse addImmigrationResponse = new AddImmigrationResponse(ResultEnum.success);
        addImmigrationResponse.setData(result);
        return addImmigrationResponse;
    }

    public BatchDeleteImmigrationResponse batchDelete(BatchDeleteImmigrationRequest batchDeleteImmigrationRequest) {
        Boolean result = this.deleteByIds(batchDeleteImmigrationRequest.getInIdList());
        BatchDeleteImmigrationResponse batchDeleteImmigrationResponse = new BatchDeleteImmigrationResponse(ResultEnum.success);
        batchDeleteImmigrationResponse.setData(result);
        return batchDeleteImmigrationResponse;
    }

    public DeleteImmigrationResponse delete(DeleteImmigrationRequest deleteImmigrationRequest) {
        Boolean result = this.deleteByPrimaryKey(deleteImmigrationRequest.getId());
        DeleteImmigrationResponse deleteImmigrationResponse = new DeleteImmigrationResponse(ResultEnum.success);
        deleteImmigrationResponse.setData(result);
        return deleteImmigrationResponse;
    }

    public ImmigrationDetailResponse detail(ImmigrationDetailRequest immigrationDetailRequest) {
        ImmigrationModel result = this.selectByPrimaryKey(immigrationDetailRequest.getId());
        result.setVideoList(JSON.parseArray(result.getVideos()));
        result.setRelatedHouse(JSON.parseArray(result.getHouses()));
        ImmigrationDetailResponse immigrationDetailResponse = new ImmigrationDetailResponse(ResultEnum.success);
        immigrationDetailResponse.setData(result);
        return immigrationDetailResponse;
    }

    public EditImmigrationResponse edit(EditImmigrationRequest editImmigrationRequest) {
        
        ImmigrationModel immigrationModel= new ImmigrationModel();
        immigrationModel.setTitle(editImmigrationRequest.getTitle());
        immigrationModel.setPicture(editImmigrationRequest.getPicture());
        immigrationModel.setPriceDetail(editImmigrationRequest.getPriceDetail());
        immigrationModel.setProjectBenefits(editImmigrationRequest.getProjectBenefits());
        immigrationModel.setApplicationProcess(editImmigrationRequest.getApplicationProcess());
        immigrationModel.setApplicationCondition(editImmigrationRequest.getApplicationCondition());
        immigrationModel.setCountryInstroduction(editImmigrationRequest.getCountryInstroduction());
        immigrationModel.setSuccessCase(editImmigrationRequest.getSuccessCase());
        immigrationModel.setPrice(editImmigrationRequest.getPrice());
        immigrationModel.setPeriod(editImmigrationRequest.getPeriod());
        immigrationModel.setIdentityType(editImmigrationRequest.getIdentityType());
        immigrationModel.setLivingRequirement(editImmigrationRequest.getLivingRequirement());
        immigrationModel.setCriminalRecord(editImmigrationRequest.getCriminalRecord());
        immigrationModel.setId(editImmigrationRequest.getId());
        immigrationModel.setVideos(editImmigrationRequest.getVideos());
        immigrationModel.setHouses(editImmigrationRequest.getHouses());
        immigrationModel.setSubTitle(editImmigrationRequest.getSubTitle());
        immigrationModel.setCountry(editImmigrationRequest.getCountry());
        immigrationModel.setDescription(editImmigrationRequest.getDescription());
        Boolean result = this.updateByPrimaryKey(immigrationModel);
        
        EditImmigrationResponse editImmigrationResponse = new EditImmigrationResponse(ResultEnum.success);
        editImmigrationResponse.setData(result);
        return editImmigrationResponse;
    }

    public ImmigrationPageListResponse searchWithPage(ImmigrationPageListRequest request) {
        ImmigrationPageListResponse response = new ImmigrationPageListResponse(ResultEnum.success);
        PaginationList<ImmigrationModel> list = this.selectByPage(request.getPageSize(),request.getPageNo());
        response.setList(list);
        response.setTotalRecord(list.getTotalRecord());
        return response;
    }

    public ImmigrationModel insert(ImmigrationModel immigrationModel) {
        return immigrationDao.addEntity(immigrationModel);
    }

    public List<ImmigrationModel> insertList(List<ImmigrationModel> immigrationModelList) {
        List<ImmigrationModel> answer = new ArrayList<ImmigrationModel>();
        for(ImmigrationModel immigrationModel : immigrationModelList ){
            answer.add(this.insert(immigrationModel));
        }
        return answer;
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return immigrationDao.deleteEntity(cond);
    }

    public Boolean deleteByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        return immigrationDao.deleteEntity(cond);
    }

    public Boolean updateByPrimaryKey(ImmigrationModel immigrationModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",immigrationModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("title",immigrationModel.getTitle());
        updateValue.put("picture",immigrationModel.getPicture());
        updateValue.put("priceDetail",immigrationModel.getPriceDetail());
        updateValue.put("projectBenefits",immigrationModel.getProjectBenefits());
        updateValue.put("applicationProcess",immigrationModel.getApplicationProcess());
        updateValue.put("applicationCondition",immigrationModel.getApplicationCondition());
        updateValue.put("countryInstroduction",immigrationModel.getCountryInstroduction());
        updateValue.put("successCase",immigrationModel.getSuccessCase());
        updateValue.put("price",immigrationModel.getPrice());
        updateValue.put("period",immigrationModel.getPeriod());
        updateValue.put("status",immigrationModel.getStatus());
        updateValue.put("identityType",immigrationModel.getIdentityType());
        updateValue.put("videos",immigrationModel.getVideos());
        updateValue.put("houses",immigrationModel.getHouses());
        updateValue.put("livingRequirement",immigrationModel.getLivingRequirement());
        updateValue.put("criminalRecord",immigrationModel.getCriminalRecord());
        updateValue.put("createTime",immigrationModel.getCreateTime());
        updateValue.put("orderNum",immigrationModel.getOrderNum());
        updateValue.put("subTitle",immigrationModel.getSubTitle());
        updateValue.put("country",immigrationModel.getCountry());
        updateValue.put("description",immigrationModel.getDescription());
        return immigrationDao.updateEntity(cond,updateValue);
    }

    public List<ImmigrationModel> selectAll() {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = allColumn();
        return immigrationDao.findEntityListByCond(cond,output,null);
    }

    public PaginationList<ImmigrationModel> selectByPage(Integer pageSize, Integer pageNo) {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = allColumn();
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setRecordPerPage(pageSize);
        paginationInfo.setCurrentPage(pageNo);
        return immigrationDao.findEntityListByCond(cond,output,paginationInfo);
    }

    public ImmigrationModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = allColumn();
        return immigrationDao.findEntityById(cond,output);
    }

    public List<ImmigrationModel> selectByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        Map<String,Object> output = allColumn();
        return immigrationDao.findEntityListByCond(cond,output,null);
    }

    public Map<String,Object> allColumn(){
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("title","1");
        output.put("picture","1");
        output.put("priceDetail","1");
        output.put("projectBenefits","1");
        output.put("applicationProcess","1");
        output.put("applicationCondition","1");
        output.put("countryInstroduction","1");
        output.put("successCase","1");
        output.put("price","1");
        output.put("period","1");
        output.put("status","1");
        output.put("videos","1");
        output.put("houses","1");
        output.put("identityType","1");
        output.put("livingRequirement","1");
        output.put("criminalRecord","1");
        output.put("createTime","1");
        output.put("orderNum","1");
        output.put("subTitle","1");
        output.put("description","1");
        output.put("country","1");
        output.put("id","1");
        return output;
    }
}
