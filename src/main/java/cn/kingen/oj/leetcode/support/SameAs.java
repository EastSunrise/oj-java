package cn.kingen.oj.leetcode.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks the same question.
 *
 * @author Kingen
 **/
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface SameAs {

    Class<?> value();

    String note() default "";
}
