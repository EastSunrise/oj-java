package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/binary-number-with-alternating-bits/">693. Binary Number with Alternating Bits</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution191
 */
@Question(
        tags = {Tag.BIT_MANIPULATION},
        difficulty = Difficulty.EASY
)
public class Solution693 {

    @Complexity(time = "O(log{n})", space = "O(1)")
    public boolean hasAlternatingBits(int n) {
        int bit = n & 1;
        n >>= 1;
        while (n > 0) {
            if ((n & 1) == bit) {
                return false;
            }
            bit = bit ^ 1;
            n >>= 1;
        }
        return true;
    }
}