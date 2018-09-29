package com.dayuxiaoyu.dashboard.web.request.cms;

import com.dayuxiaoyu.dashboard.web.request.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/28 12/53
 * @since
 */
public class AddImageRequest extends BaseRequest {

    @NotNull
    private String name;

    @NotNull
    private String url;

    @NotNull
    private String type;

    @NotNull
    private Integer categoryId;

    @NotNull
    private Integer size = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
