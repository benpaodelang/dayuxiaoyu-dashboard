package com.dayuxiaoyu.dashboard.service.cms;

import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.RecommendPositionDao;
import com.dayuxiaoyu.dashboard.model.cms.RecommendPositionModel;
import com.dayuxiaoyu.dashboard.web.request.cms.AddRecommendPositionRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.EditRecommendPositionRequest;
import com.dayuxiaoyu.dashboard.web.response.BaseListResponse;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecommendPositionService {
    @Resource
    private RecommendPositionDao recommendPositionDao;

    public BaseResponse add(AddRecommendPositionRequest request) {
        
        RecommendPositionModel recommendPositionModel= new RecommendPositionModel();
        recommendPositionModel.setName(request.getName());
        recommendPositionModel.setType(request.getType());
        
        RecommendPositionModel result = this.insert(recommendPositionModel);

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

    public BaseResponse edit(EditRecommendPositionRequest request) {
        
        RecommendPositionModel recommendPositionModel= new RecommendPositionModel();
        recommendPositionModel.setName(request.getName());
        recommendPositionModel.setId(request.getId());
        Boolean result = this.updateByPrimaryKey(recommendPositionModel);

        BaseResponse response = new BaseResponse(ResultEnum.success);
        response.setData(result);
        return response;
    }

    public BaseListResponse search(String type) {
        BaseListResponse response = new BaseListResponse(ResultEnum.success);
        response.setList(this.selectAllByType(type));
        return response;
    }

    public RecommendPositionModel insert(RecommendPositionModel recommendPositionModel) {
        return recommendPositionDao.addEntity(recommendPositionModel);
    }

    public List<RecommendPositionModel> insertList(List<RecommendPositionModel> recommendPositionModelList) {
        List<RecommendPositionModel> answer = new ArrayList<RecommendPositionModel>();
        for(RecommendPositionModel recommendPositionModel : recommendPositionModelList ){
            answer.add(this.insert(recommendPositionModel));
        }
        return answer;
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return recommendPositionDao.deleteEntity(cond);
    }

    public Boolean updateByPrimaryKey(RecommendPositionModel recommendPositionModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",recommendPositionModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("name",recommendPositionModel.getName());
        updateValue.put("createTime",recommendPositionModel.getCreateTime());
        updateValue.put("type",recommendPositionModel.getType());
        return recommendPositionDao.updateEntity(cond,updateValue);
    }

    public List<RecommendPositionModel> selectAllByType(String type) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("type",type);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("name","1");
        output.put("createTime","1");
        output.put("id","1");
        output.put("type","1");
        return recommendPositionDao.findEntityListByCond(cond,output,null);
    }

    public List<RecommendPositionModel> selectAll() {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("name","1");
        output.put("createTime","1");
        output.put("id","1");
        output.put("type","1");
        return recommendPositionDao.findEntityListByCond(cond,output,null);
    }

    public RecommendPositionModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("name","1");
        output.put("createTime","1");
        output.put("id","1");
        output.put("type","1");
        return recommendPositionDao.findEntityById(cond,output);
    }
}
