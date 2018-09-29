package com.dayuxiaoyu.dashboard.model.cms;

import java.sql.Timestamp;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/28 12/45
 * @since
 */
public class ImageGroupModel {

    private Integer id;

    private String name;

    private Timestamp createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
