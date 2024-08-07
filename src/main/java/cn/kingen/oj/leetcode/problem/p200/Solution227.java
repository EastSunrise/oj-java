package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.calculateExpression;

/**
 * <a href="https://leetcode.cn/problems/basic-calculator-ii/">227. Basic Calculator II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution224
 * @see cn.kingen.oj.leetcode.problem.p200.Solution282
 * @see cn.kingen.oj.leetcode.problem.p700.Solution772
 */
@Question(
        tags = {Tag.STACK, Tag.MATH, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution227 {

    public int calculate(String s) {
        return calculateExpression(s);
    }
}