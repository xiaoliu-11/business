package com.example.business.annotation;


import java.lang.annotation.*;

/**
 * @author 刘树国
 */
@Target(ElementType.METHOD)  //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) // 注解在哪个阶段执行 运行时可见
@Documented
public @interface LogAnnotation {

    //记录日志的操作类型
    String value() default "";
}
