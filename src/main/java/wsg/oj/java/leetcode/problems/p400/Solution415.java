package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution2;
import wsg.oj.java.leetcode.problems.p0.Solution43;
import wsg.oj.java.leetcode.problems.p900.Solution989;

/**
 * 415. Add Strings (Easy)
 *
 * @author Kingen
 * @see Solution2
 * @see Solution43
 * @see Solution989
 * @see <a href="https://leetcode-cn.com/problems/add-strings/">Add Strings</a>
 * @since 2021-07-14
 */
public class Solution415 implements Solution {

    /**
     * Adds the two numbers with a carry.
     *
     * @complexity T=O(m+n)
     * @complexity S=O(max(m,n))
     */
    public String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1, i2 = num2.length() - 1;
        char[] res = new char[Math.max(i1, i2) + 2];
        int i = res.length - 1, carry = 0;
        while (i1 >= 0 && i2 >= 0) {
            int sum = num1.charAt(i1--) - '0' + num2.charAt(i2--) - '0' + carry;
            carry = sum / 10;
            res[i--] = (char) (sum % 10 + '0');
        }
        while (i1 >= 0) {
            int sum = num1.charAt(i1--) - '0' + carry;
            carry = sum / 10;
            res[i--] = (char) (sum % 10 + '0');
        }
        while (i2 >= 0) {
            int sum = num2.charAt(i2--) - '0' + carry;
            carry = sum / 10;
            res[i--] = (char) (sum % 10 + '0');
        }
        if (carry == 0) {
            return String.valueOf(res, 1, res.length - 1);
        }
        res[i] = (char) (carry + '0');
        return new String(res);
    }
}
