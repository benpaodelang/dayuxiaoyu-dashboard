package com.dayuxiaoyu.dashboard.web.request.cms;

import com.dayuxiaoyu.dashboard.web.request.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/27 15/08
 * @since
 */
public class AddRecommendRequest extends BaseRequest {

    @NotNull
    private Integer positionId;

    @NotNull
    private Integer orderNum;

    @NotNull
    private String title;

    @NotNull
    private Integer contentId;

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
