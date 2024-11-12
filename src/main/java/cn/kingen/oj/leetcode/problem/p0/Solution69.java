package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/sqrtx/">69. Sqrt(x)</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution50
 * @see cn.kingen.oj.leetcode.problem.p300.Solution367
 */
@Question(
        tags = {Tag.MATH, Tag.BINARY_SEARCH},
        difficulty = Difficulty.EASY
)
public class Solution69 {

    @Complexity(time = "O(log n)", space = "O(1)")
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int a = 1, b = x;
        while (a < b) {
            b = a + ((b - a) >> 1);
            a = x / b;
        }
        return b;
    }
}