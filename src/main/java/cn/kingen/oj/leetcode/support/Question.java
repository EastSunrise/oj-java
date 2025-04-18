package cn.kingen.oj.leetcode.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Kingen
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Question {

    /**
     * @return {@code true} if the question is paid only.
     */
    boolean paidOnly() default false;

    /**
     * @return the tags of the question.
     */
    Tag[] tags() default {};

    /**
     * @return the difficulty of the question.
     */
    Difficulty difficulty();

    /**
     * @return the date as daily question
     */
    String date() default "";

    /**
     * @return associated weekly contest number
     */
    int contest() default 0;

    /**
     * @return associated biweekly contest number
     */
    int contest2() default 0;
}
