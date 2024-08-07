package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.ROMAN_SYMBOLS;

/**
 * <a href="https://leetcode.cn/problems/roman-to-integer/">13. Roman to Integer</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution12
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.MATH, Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution13 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int ret = 0;
        int last = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char ch = chars[i];
            int value = ROMAN_SYMBOLS.get(ch);
            if (value < last) {
                ret -= value;
            } else {
                ret += value;
            }
            last = value;
        }
        return ret;
    }
}