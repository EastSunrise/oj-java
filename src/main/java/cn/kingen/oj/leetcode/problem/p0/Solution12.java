package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.ROMAN_NUMBERS;

/**
 * <a href="https://leetcode.cn/problems/integer-to-roman/">12. Integer to Roman</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution13
 * @see cn.kingen.oj.leetcode.problem.p200.Solution273
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.MATH, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution12 {

    /**
     * Thinks of 1-3, 4, 5-8, 9 separately.
     */
    @Complexity(time = "O(n)", space = "O(1)")
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit < 4) {
                while (digit-- > 0) {
                    builder.append(ROMAN_NUMBERS[i]);
                }
            } else if (digit == 4) {
                builder.append(ROMAN_NUMBERS[i + 1]).append(ROMAN_NUMBERS[i]);
            } else if (digit < 9) {
                while (digit-- > 5) {
                    builder.append(ROMAN_NUMBERS[i]);
                }
                builder.append(ROMAN_NUMBERS[i + 1]);
            } else {
                builder.append(ROMAN_NUMBERS[i + 2]).append(ROMAN_NUMBERS[i]);
            }
            num /= 10;
            i += 2;
        }
        return builder.reverse().toString();
    }
}