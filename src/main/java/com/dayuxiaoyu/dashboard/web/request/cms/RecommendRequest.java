package com.dayuxiaoyu.dashboard.web.request.cms;

import com.dayuxiaoyu.dashboard.web.request.BaseRequest;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/27 18/21
 * @since
 */
public class RecommendRequest extends BaseRequest {

    @NotNull
    private List<Integer> positionList = new ArrayList<Integer>();

    @NotNull
    private Integer contentId;

    @NotNull
    private String title;

    @NotNull
    private String type;

    public List<Integer> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Integer> positionList) {
        this.positionList = positionList;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
