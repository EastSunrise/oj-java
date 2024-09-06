package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/clear-digits/">3174. Clear Digits</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STACK, Tag.STRING, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution3174 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String clearDigits(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int size = 0;
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if ('0' <= ch && ch <= '9') {
                size--;
            } else {
                chars[size++] = ch;
            }
        }
        return new String(chars, 0, size);
    }
}