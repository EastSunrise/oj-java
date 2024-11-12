package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/valid-perfect-square/">367. Valid Perfect Square</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution69
 * @see cn.kingen.oj.leetcode.problem.p600.Solution633
 */
@Question(
        tags = {Tag.MATH, Tag.BINARY_SEARCH},
        difficulty = Difficulty.EASY
)
public class Solution367 {

    @Complexity(time = "O(log n)", space = "O(1)")
    public boolean isPerfectSquare(int num) {
        int a = 1, b = num;
        while (a < b) {
            b = (a + b) >> 1;
            a = num / b;
        }
        return b * b == num;
    }
}