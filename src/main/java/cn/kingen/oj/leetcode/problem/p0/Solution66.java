package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/plus-one/">66. Plus One</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution43
 * @see cn.kingen.oj.leetcode.problem.p0.Solution67
 * @see cn.kingen.oj.leetcode.problem.p300.Solution369
 * @see cn.kingen.oj.leetcode.problem.p900.Solution989
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Solution66 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                carry = false;
                break;
            }
        }
        if (!carry) {
            return digits;
        }
        int[] copy = new int[digits.length + 1];
        copy[0] = 1;
        System.arraycopy(digits, 0, copy, 1, digits.length);
        return copy;
    }
}