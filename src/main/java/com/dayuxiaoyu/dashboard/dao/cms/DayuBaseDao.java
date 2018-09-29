package com.dayuxiaoyu.dashboard.dao.cms;

import com.dayuxiaoyu.dashboard.dao.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author zyp
 * @version 1.0
 * @time 2017/12/15 13/43
 * @since
 */
public class DayuBaseDao<Entity> extends BaseDao<Entity> {
    @Autowired
    @Override
    public void setMySqlSessionFactory(
            @Qualifier("dayuSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        this.setSqlSessionFactory(sqlSessionFactory);
    }
}
