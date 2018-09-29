package com.dayuxiaoyu.dashboard.service.cms;

import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.CountryDao;
import com.dayuxiaoyu.dashboard.model.cms.CountryModel;
import com.dayuxiaoyu.dashboard.web.request.cms.*;
import com.dayuxiaoyu.dashboard.web.response.BaseListResponse;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import com.dayuxiaoyu.dashboard.web.response.cms.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountryService {
    @Resource
    private CountryDao countryDao;

    public BaseResponse order(Integer id, Integer orderNum){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        CountryModel countryModel = new CountryModel();
        countryModel.setId(id);
        countryModel.setOrderNum(orderNum);
        this.updateByPrimaryKey(countryModel);
        return response;
    }

    public BaseResponse add(AddCountryRequest request) {
        
        CountryModel countryModel= new CountryModel();
        countryModel.setName(request.getName());
        countryModel.setOrderNum(request.getOrderNum());
        CountryModel result = this.insert(countryModel);

        BaseResponse response = new BaseResponse(ResultEnum.success);
        response.setData(result);
        return response;
    }

    public BaseResponse delete(Integer id) {
        Boolean result = this.deleteByPrimaryKey(id);
        BaseResponse response = new BaseResponse(ResultEnum.success);
        response.setData(result);
        return response;
    }

    public BaseResponse edit(EditCountryRequest editCountryRequest) {
        
        CountryModel countryModel= new CountryModel();
        countryModel.setName(editCountryRequest.getName());
        countryModel.setId(editCountryRequest.getId());
        countryModel.setOrderNum(editCountryRequest.getId());
        Boolean result = this.updateByPrimaryKey(countryModel);

        BaseResponse response = new BaseResponse(ResultEnum.success);
        response.setData(result);
        return response;
    }

    public BaseListResponse search() {
        BaseListResponse response = new BaseListResponse(ResultEnum.success);
        response.setList(this.selectAll());
        return response;
    }


    public List<CountryModel> countryTree(){
        return this.buildTree(0);
    }

    public List<CountryModel> buildTree(Integer parentId){
        List<CountryModel> countrys = this.selectByParentId(parentId);
        for (CountryModel country : countrys){
            country.setChildren(this.buildTree(country.getId()));
        }
        return countrys;
    }

    public CountryModel insert(CountryModel countryModel) {
        return countryDao.addEntity(countryModel);
    }

    public List<CountryModel> insertList(List<CountryModel> countryModelList) {
        List<CountryModel> answer = new ArrayList<CountryModel>();
        for(CountryModel countryModel : countryModelList ){
            answer.add(this.insert(countryModel));
        }
        return answer;
    }

    public Boolean deleteByParentId(Integer parentId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("parentId",parentId);
        return countryDao.deleteEntity(cond);
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return countryDao.deleteEntity(cond);
    }

    public Boolean deleteByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        return countryDao.deleteEntity(cond);
    }

    public Boolean updateByParentId(CountryModel countryModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("parentId",countryModel.getParentId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("parentId",countryModel.getParentId());
        updateValue.put("name",countryModel.getName());
        updateValue.put("icon",countryModel.getIcon());
        updateValue.put("createTime",countryModel.getCreateTime());
        updateValue.put("updateTime",countryModel.getUpdateTime());
        updateValue.put("orderNum",countryModel.getOrderNum());
        return countryDao.updateEntity(cond,updateValue);
    }

    public Boolean updateByPrimaryKey(CountryModel countryModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",countryModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("parentId",countryModel.getParentId());
        updateValue.put("name",countryModel.getName());
        updateValue.put("icon",countryModel.getIcon());
        updateValue.put("createTime",countryModel.getCreateTime());
        updateValue.put("updateTime",countryModel.getUpdateTime());
        updateValue.put("orderNum",countryModel.getOrderNum());
        return countryDao.updateEntity(cond,updateValue);
    }

    public List<CountryModel> selectAll() {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = this.allColumn();
        return countryDao.findEntityListByCond(cond,output,null);
    }

    public CountryModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = this.allColumn();
        return countryDao.findEntityById(cond,output);
    }

    public List<CountryModel> selectByParentId(Integer parentId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("parentId",parentId);
        Map<String,Object> output = this.allColumn();
        return countryDao.findEntityListByCond(cond,output,null);
    }

    public List<CountryModel> selectByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        Map<String,Object> output = this.allColumn();
        return countryDao.findEntityListByCond(cond,output,null);
    }

    public Map<String,Object> allColumn(){
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("parentId","1");
        output.put("name","1");
        output.put("icon","1");
        output.put("createTime","1");
        output.put("updateTime","1");
        output.put("orderNum","1");
        output.put("id","1");
        return output;
    }
}
