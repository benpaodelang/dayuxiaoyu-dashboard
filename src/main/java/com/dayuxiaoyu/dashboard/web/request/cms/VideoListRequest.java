package com.dayuxiaoyu.dashboard.web.request.cms;

import com.dayuxiaoyu.dashboard.web.request.BaseRequest;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class VideoListRequest extends BaseRequest {
    @NotNull
    private String path;

    @NotNull
    private String name;

    @NotNull
    private Timestamp createTime;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
