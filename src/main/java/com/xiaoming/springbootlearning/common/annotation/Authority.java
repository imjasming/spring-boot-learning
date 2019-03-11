package com.xiaoming.springbootlearning.common.annotation;

import java.lang.annotation.*;

/**
 * @author Xiaoming.
 * Created on 2019/02/24 21:34.
 * Description :
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authority {

    String value() default "admin";
}
