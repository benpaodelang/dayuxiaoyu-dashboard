package com.dayuxiaoyu.dashboard.service.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.PassportDao;
import com.dayuxiaoyu.dashboard.dao.pagination.PaginationInfo;
import com.dayuxiaoyu.dashboard.dao.pagination.PaginationList;
import com.dayuxiaoyu.dashboard.model.cms.PassportModel;
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
public class PassportService {
    @Resource
    private PassportDao passportDao;

    public BaseResponse up(Integer id){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        PassportModel passportModel = new PassportModel();
        passportModel.setId(id);
        passportModel.setStatus(1);
        this.updateByPrimaryKey(passportModel);
        return response;
    }

    public BaseResponse order(Integer id,Integer orderNum){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        PassportModel passportModel = new PassportModel();
        passportModel.setId(id);
        passportModel.setOrderNum(orderNum);
        this.updateByPrimaryKey(passportModel);
        return response;
    }

    public BaseResponse down(Integer id){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        PassportModel passportModel = new PassportModel();
        passportModel.setId(id);
        passportModel.setStatus(0);
        this.updateByPrimaryKey(passportModel);
        return response;
    }

    public AddPassportResponse add(AddPassportRequest addPassportRequest) {
        
        PassportModel passportModel= new PassportModel();
        passportModel.setTitle(addPassportRequest.getTitle());
        passportModel.setPicture(addPassportRequest.getPicture());
        passportModel.setPriceDetail(addPassportRequest.getPriceDetail());
        passportModel.setProjectBenefits(addPassportRequest.getProjectBenefits());
        passportModel.setApplicationProcess(addPassportRequest.getApplicationProcess());
        passportModel.setApplicationCondition(addPassportRequest.getApplicationCondition());
        passportModel.setCountryInstroduction(addPassportRequest.getCountryInstroduction());
        passportModel.setSuccessCase(addPassportRequest.getSuccessCase());
        passportModel.setPrice(addPassportRequest.getPrice());
        passportModel.setPeriod(addPassportRequest.getPeriod());
        passportModel.setIdentityType(addPassportRequest.getIdentityType());
        passportModel.setLivingRequirement(addPassportRequest.getLivingRequirement());
        passportModel.setCriminalRecord(addPassportRequest.getCriminalRecord());
        passportModel.setVideos(addPassportRequest.getVideos());
        passportModel.setHouses(addPassportRequest.getHouses());
        passportModel.setSubTitle(addPassportRequest.getSubTitle());
        passportModel.setCountry(addPassportRequest.getCountry());
        passportModel.setDescription(addPassportRequest.getDescription());
        
        PassportModel result = this.insert(passportModel);
        
        AddPassportResponse addPassportResponse = new AddPassportResponse(ResultEnum.success);
        addPassportResponse.setData(result);
        return addPassportResponse;
    }

    public BatchDeletePassportResponse batchDelete(BatchDeletePassportRequest batchDeletePassportRequest) {
        Boolean result = this.deleteByIds(batchDeletePassportRequest.getInIdList());
        BatchDeletePassportResponse batchDeletePassportResponse = new BatchDeletePassportResponse(ResultEnum.success);
        batchDeletePassportResponse.setData(result);
        return batchDeletePassportResponse;
    }

    public DeletePassportResponse delete(DeletePassportRequest deletePassportRequest) {
        Boolean result = this.deleteByPrimaryKey(deletePassportRequest.getId());
        DeletePassportResponse deletePassportResponse = new DeletePassportResponse(ResultEnum.success);
        deletePassportResponse.setData(result);
        return deletePassportResponse;
    }

    public PassportDetailResponse detail(PassportDetailRequest passportDetailRequest) {
        PassportModel result = this.selectByPrimaryKey(passportDetailRequest.getId());
        result.setVideoList(JSON.parseArray(result.getVideos()));
        result.setRelatedHouse(JSON.parseArray(result.getHouses()));
        PassportDetailResponse passportDetailResponse = new PassportDetailResponse(ResultEnum.success);
        passportDetailResponse.setData(result);
        return passportDetailResponse;
    }

    public EditPassportResponse edit(EditPassportRequest editPassportRequest) {
        
        PassportModel passportModel= new PassportModel();
        passportModel.setTitle(editPassportRequest.getTitle());
        passportModel.setPicture(editPassportRequest.getPicture());
        passportModel.setPriceDetail(editPassportRequest.getPriceDetail());
        passportModel.setProjectBenefits(editPassportRequest.getProjectBenefits());
        passportModel.setApplicationProcess(editPassportRequest.getApplicationProcess());
        passportModel.setApplicationCondition(editPassportRequest.getApplicationCondition());
        passportModel.setCountryInstroduction(editPassportRequest.getCountryInstroduction());
        passportModel.setSuccessCase(editPassportRequest.getSuccessCase());
        passportModel.setPrice(editPassportRequest.getPrice());
        passportModel.setPeriod(editPassportRequest.getPeriod());
        passportModel.setIdentityType(editPassportRequest.getIdentityType());
        passportModel.setLivingRequirement(editPassportRequest.getLivingRequirement());
        passportModel.setCriminalRecord(editPassportRequest.getCriminalRecord());
        passportModel.setId(editPassportRequest.getId());
        passportModel.setVideos(editPassportRequest.getVideos());
        passportModel.setHouses(editPassportRequest.getHouses());
        passportModel.setSubTitle(editPassportRequest.getSubTitle());
        passportModel.setDescription(editPassportRequest.getDescription());
        passportModel.setCountry(editPassportRequest.getCountry());
        Boolean result = this.updateByPrimaryKey(passportModel);
        
        EditPassportResponse editPassportResponse = new EditPassportResponse(ResultEnum.success);
        editPassportResponse.setData(result);
        return editPassportResponse;
    }


    public PassportPageListResponse searchWithPage(PassportPageListRequest request) {
        PassportPageListResponse response = new PassportPageListResponse(ResultEnum.success);
        PaginationList<PassportModel> list = this.selectByPage(request.getPageSize(),request.getPageNo());
        response.setList(list);
        response.setTotalRecord(list.getTotalRecord());
        return response;
    }

    public PassportModel insert(PassportModel passportModel) {
        return passportDao.addEntity(passportModel);
    }

    public List<PassportModel> insertList(List<PassportModel> passportModelList) {
        List<PassportModel> answer = new ArrayList<PassportModel>();
        for(PassportModel passportModel : passportModelList ){
            answer.add(this.insert(passportModel));
        }
        return answer;
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return passportDao.deleteEntity(cond);
    }

    public Boolean deleteByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        return passportDao.deleteEntity(cond);
    }

    public Boolean updateByPrimaryKey(PassportModel passportModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",passportModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("title",passportModel.getTitle());
        updateValue.put("picture",passportModel.getPicture());
        updateValue.put("priceDetail",passportModel.getPriceDetail());
        updateValue.put("projectBenefits",passportModel.getProjectBenefits());
        updateValue.put("applicationProcess",passportModel.getApplicationProcess());
        updateValue.put("applicationCondition",passportModel.getApplicationCondition());
        updateValue.put("countryInstroduction",passportModel.getCountryInstroduction());
        updateValue.put("successCase",passportModel.getSuccessCase());
        updateValue.put("price",passportModel.getPrice());
        updateValue.put("period",passportModel.getPeriod());
        updateValue.put("identityType",passportModel.getIdentityType());
        updateValue.put("videos",passportModel.getVideos());
        updateValue.put("houses",passportModel.getHouses());
        updateValue.put("status",passportModel.getStatus());
        updateValue.put("livingRequirement",passportModel.getLivingRequirement());
        updateValue.put("criminalRecord",passportModel.getCriminalRecord());
        updateValue.put("createTime",passportModel.getCreateTime());
        updateValue.put("orderNum",passportModel.getOrderNum());
        updateValue.put("country",passportModel.getCountry());
        updateValue.put("subTitle",passportModel.getSubTitle());
        updateValue.put("description",passportModel.getDescription());
        return passportDao.updateEntity(cond,updateValue);
    }

    public List<PassportModel> selectAll() {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = allColumn();
        return passportDao.findEntityListByCond(cond,output,null);
    }

    public PassportModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = allColumn();
        return passportDao.findEntityById(cond,output);
    }

    public PaginationList<PassportModel> selectByPage(Integer pageSize, Integer pageNo) {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = allColumn();
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setRecordPerPage(pageSize);
        paginationInfo.setCurrentPage(pageNo);
        return passportDao.findEntityListByCond(cond,output,paginationInfo);
    }

    public List<PassportModel> selectByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        Map<String,Object> output = allColumn();
        return passportDao.findEntityListByCond(cond,output,null);
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
        output.put("status","1");
        output.put("period","1");
        output.put("identityType","1");
        output.put("livingRequirement","1");
        output.put("criminalRecord","1");
        output.put("createTime","1");
        output.put("orderNum","1");
        output.put("videos","1");
        output.put("houses","1");
        output.put("id","1");
        output.put("country","1");
        output.put("subTitle","1");
        output.put("description","1");
        return output;
    }
}
