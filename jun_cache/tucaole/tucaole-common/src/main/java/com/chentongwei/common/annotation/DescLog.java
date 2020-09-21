package com.chentongwei.common.annotation;

import java.lang.annotation.*;

/**
 * @author TongWei.Chen 2017-9-21 19:31:28
 * @Project tucaole
 * @Description: 用于记录系统操作日志的注解（具体操作描述） -- 方法注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DescLog {

    /**
     * 操作描述
     *
     * @return
     */
    String value();
}
