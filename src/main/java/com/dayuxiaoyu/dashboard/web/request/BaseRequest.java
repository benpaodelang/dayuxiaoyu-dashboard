package com.dayuxiaoyu.dashboard.web.request;

import com.dayuxiaoyu.dashboard.util.ValidationResult;
import com.dayuxiaoyu.dashboard.util.ValidationUtils;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/22 18/51
 * @since
 */
public class BaseRequest {

    public ValidationResult validate(){
        return ValidationUtils.validateEntity(this);
    }

}
