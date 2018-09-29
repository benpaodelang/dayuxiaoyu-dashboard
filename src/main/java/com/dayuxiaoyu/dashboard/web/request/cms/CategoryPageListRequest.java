package com.dayuxiaoyu.dashboard.web.request.cms;

import com.dayuxiaoyu.dashboard.web.request.BaseRequest;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class CategoryPageListRequest extends BaseRequest {
    @NotNull
    private Integer parentId;

    @NotNull
    private String name;

    @NotNull
    private String icon;

    @NotNull
    private Integer type;

    @NotNull
    private Integer show;

    @NotNull
    private String path;

    @NotNull
    private Timestamp createTime;

    private Timestamp createTimeUp;

    private Timestamp createTimeDown;

    @NotNull
    private Timestamp updateTime;

    @NotNull
    private Integer order;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getShow() {
        return show;
    }

    public void setShow(Integer show) {
        this.show = show;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getCreateTimeUp() {
        return createTimeUp;
    }

    public void setCreateTimeUp(Timestamp createTimeUp) {
        this.createTimeUp = createTimeUp;
    }

    public Timestamp getCreateTimeDown() {
        return createTimeDown;
    }

    public void setCreateTimeDown(Timestamp createTimeDown) {
        this.createTimeDown = createTimeDown;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
