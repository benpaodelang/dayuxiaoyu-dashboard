package com.dayuxiaoyu.dashboard.service.cms;

import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.AdvisoryDao;
import com.dayuxiaoyu.dashboard.dao.pagination.PaginationInfo;
import com.dayuxiaoyu.dashboard.dao.pagination.PaginationList;
import com.dayuxiaoyu.dashboard.model.cms.AdvisoryModel;
import com.dayuxiaoyu.dashboard.web.request.cms.*;
import com.dayuxiaoyu.dashboard.web.response.cms.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdvisoryService {
    @Resource
    private AdvisoryDao advisoryDao;

    public AddAdvisoryResponse add(AddAdvisoryRequest addAdvisoryRequest) {
        
        AdvisoryModel advisoryModel= new AdvisoryModel();
        advisoryModel.setCountry(addAdvisoryRequest.getCountry());
        advisoryModel.setName(addAdvisoryRequest.getName());
        advisoryModel.setPhone(addAdvisoryRequest.getPhone());
        advisoryModel.setCreateTime(addAdvisoryRequest.getCreateTime());
        advisoryModel.setStatus(addAdvisoryRequest.getStatus());
        advisoryModel.setImmigrationRequest(addAdvisoryRequest.getImmigrationRequest());
        advisoryModel.setTimeRequest(addAdvisoryRequest.getTimeRequest());
        advisoryModel.setBusinessExperience(addAdvisoryRequest.getBusinessExperience());
        advisoryModel.setPriceRequest(addAdvisoryRequest.getPriceRequest());
        advisoryModel.setOverseasExperience(addAdvisoryRequest.getOverseasExperience());
        advisoryModel.setRiskTolerance(addAdvisoryRequest.getRiskTolerance());
        
        AdvisoryModel result = this.insert(advisoryModel);
        
        AddAdvisoryResponse addAdvisoryResponse = new AddAdvisoryResponse(ResultEnum.success);
        addAdvisoryResponse.setData(result);
        return addAdvisoryResponse;
    }

    public BatchDeleteAdvisoryResponse batchDelete(BatchDeleteAdvisoryRequest batchDeleteAdvisoryRequest) {
        Boolean result = this.deleteByIds(batchDeleteAdvisoryRequest.getInIdList());
        BatchDeleteAdvisoryResponse batchDeleteAdvisoryResponse = new BatchDeleteAdvisoryResponse(ResultEnum.success);
        batchDeleteAdvisoryResponse.setData(result);
        return batchDeleteAdvisoryResponse;
    }

    public DeleteAdvisoryResponse delete(DeleteAdvisoryRequest deleteAdvisoryRequest) {
        Boolean result = this.deleteByPrimaryKey(deleteAdvisoryRequest.getId());
        DeleteAdvisoryResponse deleteAdvisoryResponse = new DeleteAdvisoryResponse(ResultEnum.success);
        deleteAdvisoryResponse.setData(result);
        return deleteAdvisoryResponse;
    }

    public AdvisoryDetailResponse detail(AdvisoryDetailRequest advisoryDetailRequest) {
        AdvisoryModel result = this.selectByPrimaryKey(advisoryDetailRequest.getId());
        AdvisoryDetailResponse advisoryDetailResponse = new AdvisoryDetailResponse(ResultEnum.success);
        advisoryDetailResponse.setData(result);
        return advisoryDetailResponse;
    }

    public EditAdvisoryResponse edit(EditAdvisoryRequest editAdvisoryRequest) {
        
        AdvisoryModel advisoryModel= new AdvisoryModel();
        advisoryModel.setCountry(editAdvisoryRequest.getCountry());
        advisoryModel.setName(editAdvisoryRequest.getName());
        advisoryModel.setPhone(editAdvisoryRequest.getPhone());
        advisoryModel.setCreateTime(editAdvisoryRequest.getCreateTime());
        advisoryModel.setStatus(editAdvisoryRequest.getStatus());
        advisoryModel.setImmigrationRequest(editAdvisoryRequest.getImmigrationRequest());
        advisoryModel.setTimeRequest(editAdvisoryRequest.getTimeRequest());
        advisoryModel.setBusinessExperience(editAdvisoryRequest.getBusinessExperience());
        advisoryModel.setPriceRequest(editAdvisoryRequest.getPriceRequest());
        advisoryModel.setOverseasExperience(editAdvisoryRequest.getOverseasExperience());
        advisoryModel.setRiskTolerance(editAdvisoryRequest.getRiskTolerance());
        advisoryModel.setId(editAdvisoryRequest.getId());
        Boolean result = this.updateByPrimaryKey(advisoryModel);
        
        EditAdvisoryResponse editAdvisoryResponse = new EditAdvisoryResponse(ResultEnum.success);
        editAdvisoryResponse.setData(result);
        return editAdvisoryResponse;
    }

    public AdvisoryPageListResponse searchWithPage(AdvisoryPageListRequest request) {
        AdvisoryPageListResponse response = new AdvisoryPageListResponse(ResultEnum.success);
        PaginationList<AdvisoryModel> list = this.selectByPage(request.getPageSize(),request.getPageNo());
        response.setList(list);
        response.setTotalRecord(list.getTotalRecord());
        return response;
    }

    public AdvisoryModel insert(AdvisoryModel advisoryModel) {
        return advisoryDao.addEntity(advisoryModel);
    }

    public List<AdvisoryModel> insertList(List<AdvisoryModel> advisoryModelList) {
        List<AdvisoryModel> answer = new ArrayList<AdvisoryModel>();
        for(AdvisoryModel advisoryModel : advisoryModelList ){
            answer.add(this.insert(advisoryModel));
        }
        return answer;
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return advisoryDao.deleteEntity(cond);
    }

    public Boolean deleteByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        return advisoryDao.deleteEntity(cond);
    }

    public Boolean updateByPrimaryKey(AdvisoryModel advisoryModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",advisoryModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("country",advisoryModel.getCountry());
        updateValue.put("name",advisoryModel.getName());
        updateValue.put("phone",advisoryModel.getPhone());
        updateValue.put("createTime",advisoryModel.getCreateTime());
        updateValue.put("status",advisoryModel.getStatus());
        updateValue.put("immigrationRequest",advisoryModel.getImmigrationRequest());
        updateValue.put("timeRequest",advisoryModel.getTimeRequest());
        updateValue.put("businessExperience",advisoryModel.getBusinessExperience());
        updateValue.put("priceRequest",advisoryModel.getPriceRequest());
        updateValue.put("overseasExperience",advisoryModel.getOverseasExperience());
        updateValue.put("riskTolerance",advisoryModel.getRiskTolerance());
        return advisoryDao.updateEntity(cond,updateValue);
    }

    public AdvisoryModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = allColumn();
        return advisoryDao.findEntityById(cond,output);
    }

    public PaginationList<AdvisoryModel> selectByPage(Integer pageSize, Integer pageNo) {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = allColumn();
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setRecordPerPage(pageSize);
        paginationInfo.setCurrentPage(pageNo);
        return advisoryDao.findEntityListByCond(cond,output,paginationInfo);
    }

    public List<AdvisoryModel> selectByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        Map<String,Object> output = allColumn();
        return advisoryDao.findEntityListByCond(cond,output,null);
    }

    public Map<String,Object> allColumn(){
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("country","1");
        output.put("name","1");
        output.put("phone","1");
        output.put("createTime","1");
        output.put("status","1");
        output.put("immigrationRequest","1");
        output.put("timeRequest","1");
        output.put("businessExperience","1");
        output.put("priceRequest","1");
        output.put("overseasExperience","1");
        output.put("riskTolerance","1");
        output.put("id","1");
        return output;
    }
}
