package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 482. License Key Formatting (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/license-key-formatting/">License Key
 * Formatting</a>
 * @since 2021-07-14
 */
public class Solution482 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String licenseKeyFormatting(String s, int k) {
        int dashes = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '-') {
                dashes++;
            }
        }
        int keysCount = s.length() - dashes;
        char[] res = new char[keysCount + (keysCount - 1) / k];
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
