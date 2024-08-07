package cn.kingen.oj.leetcode.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks the time and space complexities of a method.
 *
 * @author Kingen
 **/
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.SOURCE)
public @interface Complexity {

    String time();

    String space();

    String note() default "";
}
