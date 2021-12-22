package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p400.Solution415;

/**
 * 43. Multiply Strings (Medium)
 *
 * @author Kingen
 * @see Solution2
 * @see Solution66
 * @see Solution67
 * @see Solution415
 * @see <a href="https://leetcode-cn.com/problems/multiply-strings/">Multiply Strings</a>
 */
public class Solution43 implements Solution {

    /**
     * Multiplies every pair of digits with a carry.
     *
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_CONSTANT
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        // the carry of last digit
        int carry = 0, len1 = num1.length(), len2 = num2.length();
        StringBuilder res = new StringBuilder(len1 + len2);
        // k: the sum of the indices of the two chosen digits
        for (int k = len1 + len2 - 2; k >= 0; k--) {
            int i = Math.max(0, k - len2 + 1);
            int iLen = Math.min(k + 1, len1);
            for (int j = k - i; i < iLen; i++, j--) {
                carry += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
            res.append(carry % 10);
            carry /= 10;
        }
        while (carry > 0) {
            res.append(carry % 10);
            carry /= 10;
        }
        return res.reverse().toString();
    }

    /**
     * Multiplies every pair of digits and stores the sum in an array, then calculate the product
     * from the array.
     *
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_M_PLUS_N
     */
    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        int[] digits = new int[len1 + len2 - 1];
        // multiply the two digits respectively and sum to the corresponding position
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                digits[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        StringBuilder res = new StringBuilder(len1 + len2);
        // sum up all result backwards
        for (int k = digits.length - 1; k >= 0; k--) {
            carry += digits[k];
            res.append(carry % 10);
            carry /= 10;
        }
        while (carry > 0) {
            res.append(carry % 10);
            carry /= 10;
        }
        return res.reverse().toString();
    }
}
