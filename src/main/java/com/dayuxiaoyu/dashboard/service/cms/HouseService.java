package com.dayuxiaoyu.dashboard.service.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.HouseDao;
import com.dayuxiaoyu.dashboard.dao.pagination.PaginationInfo;
import com.dayuxiaoyu.dashboard.dao.pagination.PaginationList;
import com.dayuxiaoyu.dashboard.model.cms.HouseModel;
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
public class HouseService {
    @Resource
    private HouseDao houseDao;

    @Resource
    private VideoService videoService;

    public BaseResponse up(Integer id){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        HouseModel houseModel = new HouseModel();
        houseModel.setId(id);
        houseModel.setStatus(1);
        this.updateByPrimaryKey(houseModel);
        return response;
    }

    public BaseResponse down(Integer id){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        HouseModel houseModel = new HouseModel();
        houseModel.setId(id);
        houseModel.setStatus(0);
        this.updateByPrimaryKey(houseModel);
        return response;
    }

    public AddHouseResponse add(AddHouseRequest addHouseRequest) {
        
        HouseModel houseModel= new HouseModel();
        houseModel.setPicture(addHouseRequest.getPicture());
        houseModel.setTitle(addHouseRequest.getTitle());
        houseModel.setDescription(addHouseRequest.getDescription());
        houseModel.setPrice(addHouseRequest.getPrice());
        houseModel.setPriceUnit(addHouseRequest.getPriceUnit());
        houseModel.setCountry(addHouseRequest.getCountry());
        houseModel.setContent(addHouseRequest.getContent());
        houseModel.setRegion(addHouseRequest.getRegion());
        houseModel.setArea(addHouseRequest.getArea());
        houseModel.setFloor(addHouseRequest.getFloor());
        houseModel.setHouseType(addHouseRequest.getHouseType());
        houseModel.setElevator(addHouseRequest.getElevator());
        houseModel.setIncome(addHouseRequest.getIncome());
        houseModel.setHuxing(addHouseRequest.getHuxing());
        houseModel.setVideos(addHouseRequest.getVideos());
        
        HouseModel result = this.insert(houseModel);
        
        AddHouseResponse addHouseResponse = new AddHouseResponse(ResultEnum.success);
        addHouseResponse.setData(result);
        return addHouseResponse;
    }

    public BatchDeleteHouseResponse batchDelete(BatchDeleteHouseRequest batchDeleteHouseRequest) {
        Boolean result = this.deleteByIds(batchDeleteHouseRequest.getInIdList());
        BatchDeleteHouseResponse batchDeleteHouseResponse = new BatchDeleteHouseResponse(ResultEnum.success);
        batchDeleteHouseResponse.setData(result);
        return batchDeleteHouseResponse;
    }

    public DeleteHouseResponse delete(DeleteHouseRequest deleteHouseRequest) {
        Boolean result = this.deleteByPrimaryKey(deleteHouseRequest.getId());
        DeleteHouseResponse deleteHouseResponse = new DeleteHouseResponse(ResultEnum.success);
        deleteHouseResponse.setData(result);
        return deleteHouseResponse;
    }

    public HouseDetailResponse detail(HouseDetailRequest houseDetailRequest) {
        HouseModel result = this.selectByPrimaryKey(houseDetailRequest.getId());

        List<Integer> videoIds = JSON.parseArray(result.getVideos(), Integer.class);
        if(videoIds.size()>0){
            result.setVideoList(videoService.selectByIds(videoIds));
        }

        HouseDetailResponse houseDetailResponse = new HouseDetailResponse(ResultEnum.success);
        houseDetailResponse.setData(result);
        return houseDetailResponse;
    }

    public EditHouseResponse edit(EditHouseRequest editHouseRequest) {
        
        HouseModel houseModel= new HouseModel();
        houseModel.setPicture(editHouseRequest.getPicture());
        houseModel.setTitle(editHouseRequest.getTitle());
        houseModel.setDescription(editHouseRequest.getDescription());
        houseModel.setPrice(editHouseRequest.getPrice());
        houseModel.setPriceUnit(editHouseRequest.getPriceUnit());
        houseModel.setCountry(editHouseRequest.getCountry());
        houseModel.setContent(editHouseRequest.getContent());
        houseModel.setRegion(editHouseRequest.getRegion());
        houseModel.setArea(editHouseRequest.getArea());
        houseModel.setFloor(editHouseRequest.getFloor());
        houseModel.setHouseType(editHouseRequest.getHouseType());
        houseModel.setElevator(editHouseRequest.getElevator());
        houseModel.setIncome(editHouseRequest.getIncome());
        houseModel.setHuxing(editHouseRequest.getHuxing());
        houseModel.setId(editHouseRequest.getId());
        houseModel.setVideos(editHouseRequest.getVideos());
        Boolean result = this.updateByPrimaryKey(houseModel);
        
        EditHouseResponse editHouseResponse = new EditHouseResponse(ResultEnum.success);
        editHouseResponse.setData(result);
        return editHouseResponse;
    }

    public HouseListResponse query(String query) {
        HouseListResponse response = new HouseListResponse(ResultEnum.success);
        response.setList(this.selectByQuery(query));
        return response;
    }

    public HousePageListResponse searchWithPage(HousePageListRequest request) {
        HousePageListResponse response = new HousePageListResponse(ResultEnum.success);
        PaginationList<HouseModel> list = this.selectByPage(request.getPageSize(),request.getPageNo());
        response.setList(list);
        response.setTotalRecord(list.getTotalRecord());
        return response;
    }

    public HouseModel insert(HouseModel houseModel) {
        return houseDao.addEntity(houseModel);
    }

    public List<HouseModel> insertList(List<HouseModel> houseModelList) {
        List<HouseModel> answer = new ArrayList<HouseModel>();
        for(HouseModel houseModel : houseModelList ){
            answer.add(this.insert(houseModel));
        }
        return answer;
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return houseDao.deleteEntity(cond);
    }

    public Boolean deleteByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        return houseDao.deleteEntity(cond);
    }

    public Boolean updateByPrimaryKey(HouseModel houseModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",houseModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("picture",houseModel.getPicture());
        updateValue.put("videos",houseModel.getVideos());
        updateValue.put("title",houseModel.getTitle());
        updateValue.put("description",houseModel.getDescription());
        updateValue.put("price",houseModel.getPrice());
        updateValue.put("priceUnit",houseModel.getPriceUnit());
        updateValue.put("country",houseModel.getCountry());
        updateValue.put("content",houseModel.getContent());
        updateValue.put("region",houseModel.getRegion());
        updateValue.put("area",houseModel.getArea());
        updateValue.put("floor",houseModel.getFloor());
        updateValue.put("houseType",houseModel.getHouseType());
        updateValue.put("elevator",houseModel.getElevator());
        updateValue.put("status",houseModel.getStatus());
        updateValue.put("income",houseModel.getIncome());
        updateValue.put("huxing",houseModel.getHuxing());
        return houseDao.updateEntity(cond,updateValue);
    }

    public PaginationList<HouseModel> selectByPage(Integer pageSize, Integer pageNo) {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = allColumn();
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setRecordPerPage(pageSize);
        paginationInfo.setCurrentPage(pageNo);
        return houseDao.findEntityListByCond(cond,output,paginationInfo);
    }

    public HouseModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = allColumn();
        return houseDao.findEntityById(cond,output);
    }

    public List<HouseModel> selectByQuery(String query){
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("titleQuery",query);
        Map<String,Object> output = allColumn();
        return houseDao.findEntityListByCond(cond,output,null);
    }

    public List<HouseModel> selectByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        Map<String,Object> output = allColumn();
        return houseDao.findEntityListByCond(cond,output,null);
    }

    public Map<String,Object> allColumn(){
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("picture","1");
        output.put("videos","1");
        output.put("title","1");
        output.put("description","1");
        output.put("price","1");
        output.put("priceUnit","1");
        output.put("country","1");
        output.put("content","1");
        output.put("region","1");
        output.put("area","1");
        output.put("status","1");
        output.put("floor","1");
        output.put("houseType","1");
        output.put("elevator","1");
        output.put("income","1");
        output.put("huxing","1");
        output.put("id","1");
        output.put("createTime","1");
        return output;
    }
}
