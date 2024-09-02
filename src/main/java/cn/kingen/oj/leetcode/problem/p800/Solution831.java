package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/masking-personal-information/">831. Masking Personal Information</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution831 {

    @Complexity(time = "O(n)", space = "O(1)")
    public String maskPII(String s) {
        int p = s.indexOf('@');
        if (p >= 0) { // email
            if (p == 1) {
                return Character.toLowerCase(s.charAt(0)) + "*****" + s.substring(p).toLowerCase();
            }
            return Character.toLowerCase(s.charAt(0)) + "*****" + Character.toLowerCase(s.charAt(p - 1)) + s.substring(p).toLowerCase();
        }

        int len = 0, n = s.length(), k = 3;
        char[] suffix = new char[4];
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if ('0' <= ch && ch <= '9') {
                len++;
                if (k >= 0) {
                    suffix[k--] = ch;
                }
            }
        }
        if (len == 10) {
            return "***-***-" + new String(suffix);
        }
        return "+" + "*".repeat(len - 10) + "-***-***-" + new String(suffix);
    }
}