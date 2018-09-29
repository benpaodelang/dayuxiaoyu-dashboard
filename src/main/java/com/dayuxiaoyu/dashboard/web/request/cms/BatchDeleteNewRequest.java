package com.dayuxiaoyu.dashboard.web.request.cms;

import com.dayuxiaoyu.dashboard.web.request.BaseRequest;

import java.util.List;

public class BatchDeleteNewRequest extends BaseRequest {
    private List<Integer> inIdList;

    public List<Integer> getInIdList() {
        return inIdList;
    }

    public void setInIdList(List<Integer> inIdList) {
        this.inIdList = inIdList;
    }
}
