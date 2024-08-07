package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static java.lang.Character.isDigit;

/**
 * <a href="https://leetcode.cn/problems/decoded-string-at-index/">880. Decoded String at Index</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STACK, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution880 {

    @Complexity(time = "O(n)", space = "O(1)")
    public String decodeAtIndex(String s, int k) {
        long len = 0;
        int i = 0, n = s.length();
        while (i < n) {
            char ch = s.charAt(i++);
            if (isDigit(ch)) {
                len *= (ch - '0');
                if (len >= k) {
                    break;
                }
            } else {
                len++;
            }
        }
        k--;
        while (--i >= 0) {
            char ch = s.charAt(i);
            if (isDigit(ch)) {
                len /= ch - '0';
                k %= (int) len;
            } else {
                len--;
                if (k == len) {
                    return ch + "";
                }
            }
        }
        return "";
    }
}