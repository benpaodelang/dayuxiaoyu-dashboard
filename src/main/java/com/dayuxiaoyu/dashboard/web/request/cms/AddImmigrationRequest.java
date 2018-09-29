package com.dayuxiaoyu.dashboard.web.request.cms;

import com.dayuxiaoyu.dashboard.web.request.BaseRequest;

import javax.validation.constraints.NotNull;

public class AddImmigrationRequest extends BaseRequest {
    @NotNull
    private String title;

    @NotNull
    private String picture;

    @NotNull
    private String subTitle;

    @NotNull
    private String description;

    @NotNull
    private String country;

    private String priceDetail;

    private String projectBenefits;

    private String applicationProcess;

    private String applicationCondition;

    private String countryInstroduction;

    private String successCase;

    private String videos = "[]";

    private String houses = "[]";

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getHouses() {
        return houses;
    }

    public void setHouses(String houses) {
        this.houses = houses;
    }

    @NotNull
    private String price = "";

    @NotNull
    private String period = "";

    @NotNull
    private String identityType = "";

    @NotNull
    private String livingRequirement = "";

    @NotNull
    private String criminalRecord = "";

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

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

}
