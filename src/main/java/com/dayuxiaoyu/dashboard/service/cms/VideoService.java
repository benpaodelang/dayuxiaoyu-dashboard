package com.dayuxiaoyu.dashboard.service.cms;

import com.dayuxiaoyu.dashboard.common.ResultEnum;
import com.dayuxiaoyu.dashboard.dao.cms.VideoDao;
import com.dayuxiaoyu.dashboard.dao.pagination.PaginationInfo;
import com.dayuxiaoyu.dashboard.dao.pagination.PaginationList;
import com.dayuxiaoyu.dashboard.model.cms.VideoModel;
import com.dayuxiaoyu.dashboard.web.request.cms.*;
import com.dayuxiaoyu.dashboard.web.response.cms.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VideoService {
    @Resource
    private VideoDao videoDao;

    public AddVideoResponse add(AddVideoRequest addVideoRequest) {
        
        VideoModel videoModel= new VideoModel();
        videoModel.setPath(addVideoRequest.getPath());
        videoModel.setName(addVideoRequest.getName());
        videoModel.setImage(addVideoRequest.getImage());
        
        VideoModel result = this.insert(videoModel);
        
        AddVideoResponse addVideoResponse = new AddVideoResponse(ResultEnum.success);
        addVideoResponse.setData(result);
        return addVideoResponse;
    }

    public BatchDeleteVideoResponse batchDelete(BatchDeleteVideoRequest batchDeleteVideoRequest) {
        Boolean result = this.deleteByIds(batchDeleteVideoRequest.getInIdList());
        BatchDeleteVideoResponse batchDeleteVideoResponse = new BatchDeleteVideoResponse(ResultEnum.success);
        batchDeleteVideoResponse.setData(result);
        return batchDeleteVideoResponse;
    }

    public DeleteVideoResponse delete(DeleteVideoRequest deleteVideoRequest) {
        Boolean result = this.deleteByPrimaryKey(deleteVideoRequest.getId());
        DeleteVideoResponse deleteVideoResponse = new DeleteVideoResponse(ResultEnum.success);
        deleteVideoResponse.setData(result);
        return deleteVideoResponse;
    }

    public VideoDetailResponse detail(VideoDetailRequest videoDetailRequest) {
        VideoModel result = this.selectByPrimaryKey(videoDetailRequest.getId());
        VideoDetailResponse videoDetailResponse = new VideoDetailResponse(ResultEnum.success);
        videoDetailResponse.setData(result);
        return videoDetailResponse;
    }

    public EditVideoResponse edit(EditVideoRequest editVideoRequest) {
        
        VideoModel videoModel= new VideoModel();
        videoModel.setPath(editVideoRequest.getPath());
        videoModel.setName(editVideoRequest.getName());
        videoModel.setId(editVideoRequest.getId());
        videoModel.setImage(editVideoRequest.getImage());
        Boolean result = this.updateByPrimaryKey(videoModel);
        
        EditVideoResponse editVideoResponse = new EditVideoResponse(ResultEnum.success);
        editVideoResponse.setData(result);
        return editVideoResponse;
    }

    public VideoListResponse query(String query){
        VideoListResponse response = new VideoListResponse(ResultEnum.success);
        response.setList(this.selectByQuery(query));
        return response;
    }

    public VideoPageListResponse searchWithPage(VideoPageListRequest videoPageListRequest) {
        VideoPageListResponse response = new VideoPageListResponse(ResultEnum.success);
        PaginationList<VideoModel> list = this.selectByPage(videoPageListRequest.getPageSize(),videoPageListRequest.getPageNo());
        response.setList(list);
        response.setTotalRecord(list.getTotalRecord());
        return response;
    }

    public VideoModel insert(VideoModel videoModel) {
        return videoDao.addEntity(videoModel);
    }

    public List<VideoModel> insertList(List<VideoModel> videoModelList) {
        List<VideoModel> answer = new ArrayList<VideoModel>();
        for(VideoModel videoModel : videoModelList ){
            answer.add(this.insert(videoModel));
        }
        return answer;
    }

    public Boolean deleteByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        return videoDao.deleteEntity(cond);
    }

    public Boolean deleteByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        return videoDao.deleteEntity(cond);
    }

    public Boolean updateByPrimaryKey(VideoModel videoModel) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",videoModel.getId());
        Map<String,Object> updateValue = new HashMap<String,Object>();
        updateValue.put("path",videoModel.getPath());
        updateValue.put("name",videoModel.getName());
        updateValue.put("image",videoModel.getImage());
        updateValue.put("createTime",videoModel.getCreateTime());
        return videoDao.updateEntity(cond,updateValue);
    }

    public VideoModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("path","1");
        output.put("name","1");
        output.put("image","1");
        output.put("createTime","1");
        output.put("id","1");
        return videoDao.findEntityById(cond,output);
    }

    public List<VideoModel> selectByQuery(String query){
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("nameQuery",query);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("path","1");
        output.put("name","1");
        output.put("image","1");
        output.put("createTime","1");
        output.put("id","1");
        return videoDao.findEntityListByCond(cond,output,null);
    }

    public PaginationList<VideoModel> selectByPage(Integer pageSize, Integer pageNo) {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("path","1");
        output.put("name","1");
        output.put("image","1");
        output.put("createTime","1");
        output.put("id","1");
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPage(pageNo);
        paginationInfo.setRecordPerPage(pageSize);
        return videoDao.findEntityListByCond(cond,output,paginationInfo);
    }

    public List<VideoModel> selectByIds(List<Integer> inIdList) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",inIdList);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("path","1");
        output.put("name","1");
        output.put("image","1");
        output.put("createTime","1");
        output.put("id","1");
        return videoDao.findEntityListByCond(cond,output,null);
    }
}
