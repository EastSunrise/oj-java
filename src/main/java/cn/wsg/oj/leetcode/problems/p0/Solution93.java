package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses (Medium)
 *
 * @author Kingen
 * @see Solution751
 * @see <a href="https://leetcode-cn.com/problems/restore-ip-addresses/">Restore IP Addresses</a>
 */
class Solution93 implements Solution {

    /**
     * Prunes when the left chars are too many or not enough.
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIpAddresses(res, s.toCharArray(), new StringBuilder(15), 4, 0);
        return res;
    }

    /**
     * @param tmp  store chosen part
     * @param left left integers to be chosen, range [0,4]
     * @param i    the start index of chars to be chosen
     */
    private void restoreIpAddresses(List<String> res, char[] chars,
        StringBuilder tmp, int left, int i) {
        if (i == chars.length || left == 0) {
            if (i == chars.length && left == 0) {
                // all chars used for four integers
                res.add(tmp.toString());
            }
            return;
        }
        if (left * 3 + i < chars.length || left + i > chars.length) {
            // if the left chars are too many or not enough
            return;
        }
        left--;
        int len = tmp.length();
        if (len != 0) {
            tmp.append('.');
        }
        int val = chars[i] - '0';
        // 0-9
        tmp.append(chars[i++]);
        restoreIpAddresses(res, chars, tmp, left, i);
        if (i < chars.length) {
            val = val * 10 + chars[i] - '0';
            if (val >= 10) {
                // 10-99
                tmp.append(chars[i++]);
                restoreIpAddresses(res, chars, tmp, left, i);
                if (i < chars.length) {
                    val = val * 10 + chars[i] - '0';
                    if (val >= 100 && val <= 255) {
                        // 100-255
                        tmp.append(chars[i++]);
                        restoreIpAddresses(res, chars, tmp, left, i);
                    }
                }
            }
        }
        tmp.delete(len, tmp.length());
    }
}
