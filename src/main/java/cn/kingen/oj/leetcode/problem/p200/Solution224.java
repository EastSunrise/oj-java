package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.calculateExpression;

/**
 * <a href="https://leetcode.cn/problems/basic-calculator/">224. Basic Calculator</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution150
 * @see cn.kingen.oj.leetcode.problem.p200.Solution227
 * @see cn.kingen.oj.leetcode.problem.p200.Solution241
 * @see cn.kingen.oj.leetcode.problem.p200.Solution282
 * @see cn.kingen.oj.leetcode.problem.p700.Solution772
 */
@Question(
        tags = {Tag.STACK, Tag.RECURSION, Tag.MATH, Tag.STRING},
        difficulty = Difficulty.HARD
)
public class Solution224 {

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        return calculateExpression(s);
    }
}