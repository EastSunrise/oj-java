package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/sum-of-two-integers/">371. Sum of Two Integers</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution2
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution371 {

    @Complexity(time = "O(C)", space = "O(1)", note = "C is the number of bits of the integer")
    public int getSum(int a, int b) {
        int carry;
        while (b != 0) {
            carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}