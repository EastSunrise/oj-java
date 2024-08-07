package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/power-of-three/">326. Power of Three</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution231
 * @see cn.kingen.oj.leetcode.problem.p300.Solution342
 */
@Question(
        tags = {Tag.RECURSION, Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Solution326 {

    @Complexity(time = "O(log_{3}{n})", space = "O(1)")
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}