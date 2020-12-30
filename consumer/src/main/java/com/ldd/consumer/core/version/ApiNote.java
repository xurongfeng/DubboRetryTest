package com.ldd.consumer.core.version;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * API方法统一注解
 *
 * @author lee
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ApiNote {


  ApiVersion version();

  boolean deprecated() default false;

  String owner() default "";

  String note() default "";

}
