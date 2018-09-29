package com.dayuxiaoyu.dashboard.web.request.cms;

import com.dayuxiaoyu.dashboard.web.request.BaseRequest;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class AdvisoryListRequest extends BaseRequest {
    @NotNull
    private String country;

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    private Timestamp createTime;

    private Timestamp createTimeUp;

    private Timestamp createTimeDown;

    @NotNull
    private Integer status;

    @NotNull
    private String immigrationRequest;

    @NotNull
    private String timeRequest;

    @NotNull
    private String businessExperience;

    @NotNull
    private String priceRequest;

    @NotNull
    private String overseasExperience;

    @NotNull
    private String riskTolerance;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImmigrationRequest() {
        return immigrationRequest;
    }

    public void setImmigrationRequest(String immigrationRequest) {
        this.immigrationRequest = immigrationRequest;
    }

    public String getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(String timeRequest) {
        this.timeRequest = timeRequest;
    }

    public String getBusinessExperience() {
        return businessExperience;
    }

    public void setBusinessExperience(String businessExperience) {
        this.businessExperience = businessExperience;
    }

    public String getPriceRequest() {
        return priceRequest;
    }

    public void setPriceRequest(String priceRequest) {
        this.priceRequest = priceRequest;
    }

    public String getOverseasExperience() {
        return overseasExperience;
    }

    public void setOverseasExperience(String overseasExperience) {
        this.overseasExperience = overseasExperience;
    }

    public String getRiskTolerance() {
        return riskTolerance;
    }

    public void setRiskTolerance(String riskTolerance) {
        this.riskTolerance = riskTolerance;
    }
}
