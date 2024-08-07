package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-odd-binary-number/">2864. Maximum Odd Binary Number</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.MATH, Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution2864 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String maximumOddBinaryNumber(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        for (int j = 0, len = chars.length; j < len; j++) {
            if (chars[j] == '1') {
                if (i != j) {
                    chars[i] = '1';
                    chars[j] = '0';
                }
                i++;
            }
        }
        chars[i - 1] = '0';
        chars[chars.length - 1] = '1';
        return new String(chars);
    }
}