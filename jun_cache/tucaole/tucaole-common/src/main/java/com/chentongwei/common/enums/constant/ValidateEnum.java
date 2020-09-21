package com.chentongwei.common.enums.constant;

/**
 * @author TongWei.Chen 2017-12-15 13:41:54
 * @Project tucaole
 * @Description: 校验枚举
 */
public enum ValidateEnum {
    /** 自定义校验器 */
    VALIDATE_ERROR("不合法")
    ;

    //状态
    private String value;

    ValidateEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
