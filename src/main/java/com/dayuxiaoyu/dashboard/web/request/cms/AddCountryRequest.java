package com.dayuxiaoyu.dashboard.web.request.cms;

import com.dayuxiaoyu.dashboard.web.request.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/27 15/38
 * @since
 */
public class AddCountryRequest extends BaseRequest {

    @NotNull
    private String name;

    @NotNull
    private Integer orderNum = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
