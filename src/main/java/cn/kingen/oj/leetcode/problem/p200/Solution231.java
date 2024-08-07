package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/power-of-two/">231. Power of Two</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution191
 * @see cn.kingen.oj.leetcode.problem.p300.Solution326
 * @see cn.kingen.oj.leetcode.problem.p300.Solution342
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.RECURSION, Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Solution231 {

    @Complexity(time = "O(log{n})", space = "O(1)")
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        while ((n & 1) == 0) {
            n >>= 1;
        }
        return n == 1;
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public boolean isPowerOfTwo_2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}