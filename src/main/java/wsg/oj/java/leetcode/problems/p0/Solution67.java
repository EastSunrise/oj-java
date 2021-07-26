package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 67. Add Binary (Easy)
 *
 * @author Kingen
 * @see Solution2
 * @see Solution43
 * @see Solution66
 * @see Solution989
 * @see <a href="https://leetcode-cn.com/problems/add-binary/">Add Binary</a>
 * @since 2021-07-11
 */
public class Solution67 implements Solution {

    /**
     * Adds the two numbers bit by bit with a carry.
     *
     * @complexity T=O(l), l=max(len(a),len(b)
     * @complexity S=O(l)
     */
    public String addBinary(String a, String b) {
        int ai = a.length() - 1, bi = b.length() - 1;
        int ri = Math.max(ai, bi) + 1;
        char[] res = new char[ri + 1];
        int carry = 0;
        while (ai >= 0 && bi >= 0) {
            int av = a.charAt(ai--) - '0';
            int bv = b.charAt(bi--) - '0';
            int sum = av + bv + carry;
            res[ri--] = (char) (sum % 2 + '0');
            carry = sum >>> 1;
        }
        if (ai < 0) {
            ai = bi;
            a = b;
        }
        while (carry > 0 && ai >= 0) {
            char ac = a.charAt(ai--);
            if (ac == '0') {
                carry = 0;
                res[ri--] = '1';
            } else {
                res[ri--] = '0';
            }
        }
        while (ai >= 0) {
            res[ri--] = a.charAt(ai--);
        }
        if (carry == 0) {
            return String.valueOf(res, 1, res.length - 1);
        }
        res[0] = '1';
        return String.valueOf(res);
    }
}
