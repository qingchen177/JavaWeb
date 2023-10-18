package top.qingchen.basicweb.aop;

import top.qingchen.basicweb.common.constant.myenum.AuditRecordOperation;

import java.lang.annotation.*;

/**
 * @author qingchen
 * @date 17/10/2023 下午 7:53
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface BasicWebLog {
    String description() default "";

    AuditRecordOperation operationType() default AuditRecordOperation.UNKNOWN;
}
