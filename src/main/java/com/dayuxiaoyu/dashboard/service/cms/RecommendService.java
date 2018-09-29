package com.dayuxiaoyu.dashboard.service.cms;

import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.RecommendDao;
import com.dayuxiaoyu.dashboard.model.cms.RecommendModel;
import com.dayuxiaoyu.dashboard.model.cms.RecommendPositionModel;
import com.dayuxiaoyu.dashboard.web.request.cms.AddRecommendRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.EditRecommendRequest;
import com.dayuxiaoyu.dashboard.web.request.cms.RecommendRequest;
import com.dayuxiaoyu.dashboard.web.response.BaseListResponse;
import com.dayuxiaoyu.dashboard.web.response.BaseResponse;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecommendService {
    @Resource
    private RecommendDao recommendDao;

    @Resource
    private RecommendPositionService recommendPositionService;

    public BaseResponse order(Integer id, Integer orderNum){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        RecommendModel recommendModel = new RecommendModel();
        recommendModel.setId(id);
        recommendModel.setOrderNum(orderNum);
        this.updateByPrimaryKey(recommendModel);
        return response;
    }

    public BaseResponse add(AddRecommendRequest request) {
        
        RecommendModel recommendModel= new RecommendModel();
        recommendModel.setTitle(request.getTitle());
        recommendModel.setOrderNum(request.getOrderNum());
        recommendModel.setPositionId(request.getPositionId());
        recommendModel.setContentId(request.getContentId());

        RecommendModel result = this.insert(recommendModel);

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

    public BaseResponse edit(EditRecommendRequest request) {
        
        RecommendModel recommendModel= new RecommendModel();
        recommendModel.setTitle(request.getTitle());
        recommendModel.setId(request.getId());
        recommendModel.setOrderNum(request.getOrderNum());

        Boolean result = this.updateByPrimaryKey(recommendModel);

        BaseResponse response = new BaseResponse(ResultEnum.success);
        response.setData(result);
        return response;
    }

    public BaseListResponse search(Integer positionId) {
        BaseListResponse response = new BaseListResponse(ResultEnum.success);
        response.setList(this.selectAllByPositionId(positionId));
        return response;
    }

    public BaseResponse recommend(RecommendRequest request){
        BaseResponse response = new BaseResponse(ResultEnum.success);

        List<Integer> oldPositionIds = this.positionList(request.getContentId(),request.getType()).getList();
        List<Integer> currentPositionIds = request.getPositionList();
        List<Integer> needDeletePositions = new ArrayList<Integer>();
        List<Integer> needAddPositions = new ArrayList<Integer>();

        for (Integer positionId:oldPositionIds){
            if(!currentPositionIds.contains(positionId)){
                needDeletePositions.add(positionId);
            }
        }

        for (Integer positionId:currentPositionIds){
            if(!oldPositionIds.contains(positionId)){
                needAddPositions.add(positionId);
            }
        }

        for (Integer positionId:needDeletePositions){
            this.deleteByContentAndPosition(request.getContentId(),positionId);
        }

        for (Integer positionId:needAddPositions){
            RecommendModel recommendModel= new RecommendModel();
            recommendModel.setPositionId(positionId);
            recommendModel.setOrderNum(0);
            recommendModel.setContentId(request.getContentId());
            recommendModel.setTitle(request.getTitle());
            recommendModel.setCreateTime(new Timestamp(System.currentTimeMillis()));
            this.insert(recommendModel);
        }
        return response;
    }

    public BaseListResponse positionList(Integer id,String type){
        BaseListResponse response = new BaseListResponse(ResultEnum.success);
        List<RecommendPositionModel> positions = recommendPositionService.selectAllByType(type);
        Map<Integer,String> positionMap = new HashMap<Integer, String>();
        for (RecommendPositionModel position : positions){
            positionMap.put(position.getId(),"1");
        }
        List<RecommendModel> recommends = this.selectAllByContentId(id);
        List<Integer> resultList = new ArrayList<Integer>();
        for (RecommendModel recommend : recommends){
            if (positionMap.containsKey(recommend.getPositionId())){
                resultList.add(recommend.getPositionId());
            }
        }
        response.setList(resultList);
        return response;
    }

    public RecommendModel insert(RecommendModel recommendModel) {
        return recommendDao.addEntity(recommendModel);
    }

    public List<RecommendModel> insertList(List<RecommendModel> recommendModelList) {
        List<RecommendModel> answer = new ArrayList<RecommendModel>();
        for(RecommendModel recommendModel : recommendModelList ){
            answer.add(this.insert(recommendModel));
        }
        return answer;
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return recommendDao.deleteEntity(cond);
    }

    public Boolean deleteByContentAndPosition(Integer contentId,Integer positionId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("contentId",contentId);
        cond.put("positionId",positionId);
        return recommendDao.deleteEntity(cond);
    }

    public Boolean updateByPrimaryKey(RecommendModel recommendModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",recommendModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("title",recommendModel.getTitle());
        updateValue.put("createTime",recommendModel.getCreateTime());
        updateValue.put("orderNum",recommendModel.getOrderNum());
        updateValue.put("positionId",recommendModel.getPositionId());
        updateValue.put("contentId",recommendModel.getContentId());
        return recommendDao.updateEntity(cond,updateValue);
    }

    public List<RecommendModel> selectAll() {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("title","1");
        output.put("createTime","1");
        output.put("id","1");
        output.put("positionId","1");
        output.put("orderNum","1");
        output.put("contentId","1");
        return recommendDao.findEntityListByCond(cond,output,null);
    }

    public List<RecommendModel> selectAllByContentId(Integer contentId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("contentId",contentId);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("title","1");
        output.put("createTime","1");
        output.put("id","1");
        output.put("positionId","1");
        output.put("orderNum","1");
        output.put("contentId","1");
        return recommendDao.findEntityListByCond(cond,output,null);
    }

    public List<RecommendModel> selectAllByPositionId(Integer positionId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("positionId",positionId);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("title","1");
        output.put("createTime","1");
        output.put("id","1");
        output.put("positionId","1");
        output.put("orderNum","1");
        output.put("contentId","1");
        return recommendDao.findEntityListByCond(cond,output,null);
    }

    public RecommendModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("title","1");
        output.put("createTime","1");
        output.put("id","1");
        output.put("positionId","1");
        output.put("orderNum","1");
        output.put("contentId","1");
        return recommendDao.findEntityById(cond,output);
    }
}
