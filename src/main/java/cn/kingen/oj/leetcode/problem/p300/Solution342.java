package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/power-of-four/">342. Power of Four</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution231
 * @see cn.kingen.oj.leetcode.problem.p300.Solution326
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.RECURSION, Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Solution342 {

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean isPowerOfFour(int n) {
        // even not power of 2
        if (n < 1 || (n & (n - 1)) != 0) {
            return false;
        }
        // a power of 2 can be represented as (3-1)^n = 3k + (-1)^n
        return n % 3 == 1;
    }
}