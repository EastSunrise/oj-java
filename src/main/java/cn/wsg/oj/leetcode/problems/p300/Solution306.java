package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p800.Solution842;

/**
 * 306. Additive Number (Medium)
 *
 * @author Kingen
 * @see Solution842
 * @see <a href="https://leetcode-cn.com/problems/additive-number/">Additive Number</a>
 */
public class Solution306 implements Solution {

    /**
     * Prunes when the left chars are not enough.
     *
     * @see #DFS
     * @see Complexity#TIME_NNN
     * @see Complexity#SPACE_NN
     */
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len <= 2) {
            return false;
        }
        char[] chars = num.toCharArray();
        for (int b = 1; b < len; b++) {
            for (int c = b + 1; c < len; c++) {
                if (isAdditiveNumber(chars, 0, b, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditiveNumber(char[] chars, int a, int b, int c) {
        if ((chars[a] == '0' && b - a > 1) || (chars[b] == '0' && c - b > 1)) {
            // leading zeros
            return false;
        }
        int cLen = Math.max(b - a, c - b);
        if (c + cLen > chars.length) {
            // not enough chars left
            return false;
        }
        int[] temp = new int[cLen];
        int i = b - 1, j = c - 1, k = cLen - 1, carry = 0;
        while (i >= a && j >= b) {
            int sum = chars[i--] - '0' + chars[j--] - '0' + carry;
            temp[k--] = sum % 10;
            carry = sum / 10;
        }
        while (i >= a) {
            int sum = chars[i--] - '0' + carry;
            temp[k--] = sum % 10;
            carry = sum / 10;
        }
        while (j >= b) {
            int sum = +chars[j--] - '0' + carry;
            temp[k--] = sum % 10;
            carry = sum / 10;
        }
        k = c;
        if (carry > 0) {
            if (chars[k++] - '0' != carry) {
                return false;
            }
        }
        for (int digit : temp) {
            if (chars[k++] - '0' != digit) {
                return false;
            }
        }
        if (k == chars.length) {
            return true;
        }
        return isAdditiveNumber(chars, b, c, k);
    }
}
