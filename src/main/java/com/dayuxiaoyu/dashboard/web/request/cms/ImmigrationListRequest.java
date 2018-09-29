package com.dayuxiaoyu.dashboard.web.request.cms;

import com.dayuxiaoyu.dashboard.web.request.BaseRequest;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class ImmigrationListRequest extends BaseRequest {
    @NotNull
    private String title;

    @NotNull
    private String picture;

    @NotNull
    private String priceDetail;

    @NotNull
    private String projectBenefits;

    @NotNull
    private String applicationProcess;

    @NotNull
    private String applicationCondition;

    @NotNull
    private String countryInstroduction;

    @NotNull
    private String successCase;

    @NotNull
    private String price;

    @NotNull
    private String period;

    @NotNull
    private String identityType;

    @NotNull
    private String livingRequirement;

    @NotNull
    private String criminalRecord;

    @NotNull
    private Timestamp createTime;

    @NotNull
    private Integer order;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPriceDetail() {
        return priceDetail;
    }

    public void setPriceDetail(String priceDetail) {
        this.priceDetail = priceDetail;
    }

    public String getProjectBenefits() {
        return projectBenefits;
    }

    public void setProjectBenefits(String projectBenefits) {
        this.projectBenefits = projectBenefits;
    }

    public String getApplicationProcess() {
        return applicationProcess;
    }

    public void setApplicationProcess(String applicationProcess) {
        this.applicationProcess = applicationProcess;
    }

    public String getApplicationCondition() {
        return applicationCondition;
    }

    public void setApplicationCondition(String applicationCondition) {
        this.applicationCondition = applicationCondition;
    }

    public String getCountryInstroduction() {
        return countryInstroduction;
    }

    public void setCountryInstroduction(String countryInstroduction) {
        this.countryInstroduction = countryInstroduction;
    }

    public String getSuccessCase() {
        return successCase;
    }

    public void setSuccessCase(String successCase) {
        this.successCase = successCase;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getLivingRequirement() {
        return livingRequirement;
    }

    public void setLivingRequirement(String livingRequirement) {
        this.livingRequirement = livingRequirement;
    }

    public String getCriminalRecord() {
        return criminalRecord;
    }

    public void setCriminalRecord(String criminalRecord) {
        this.criminalRecord = criminalRecord;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
