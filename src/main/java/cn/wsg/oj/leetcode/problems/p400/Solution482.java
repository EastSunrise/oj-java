package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 482. License Key Formatting (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/license-key-formatting/">License Key
 * Formatting</a>
 */
public class Solution482 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public String licenseKeyFormatting(String s, int k) {
        int len = 0;
        for (char ch : s.toCharArray()) {
            if (ch != '-') {
                len++;
            }
        }
        char[] res = new char[len + (len - 1) / k];
        int i = s.length() - 1, c = 0, j = res.length - 1;
        while (i >= 0) {
            char ch = s.charAt(i--);
            if (ch != '-') {
                if (ch > 'Z') {
                    ch -= 32;
                }
                if (c == k) {
                    res[j--] = '-';
                    c = 0;
                }
                res[j--] = ch;
                c++;
            }
        }
        return new String(res);
    }
}
