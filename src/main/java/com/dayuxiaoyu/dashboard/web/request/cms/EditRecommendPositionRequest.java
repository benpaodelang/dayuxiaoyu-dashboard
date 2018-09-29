package com.dayuxiaoyu.dashboard.web.request.cms;

import com.dayuxiaoyu.dashboard.web.request.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/27 15/03
 * @since
 */
public class EditRecommendPositionRequest extends BaseRequest {

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
