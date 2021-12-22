package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p900.Solution989;

/**
 * 67. Add Binary (Easy)
 *
 * @author Kingen
 * @see Solution2
 * @see Solution43
 * @see Solution66
 * @see Solution989
 * @see <a href="https://leetcode-cn.com/problems/add-binary/">Add Binary</a>
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
            int sum = a.charAt(ai--) - '0' + b.charAt(bi--) - '0' + carry;
            res[ri--] = (char) (sum % 2 + '0');
            carry = sum >>> 1;
        }
        while (ai >= 0) {
            int sum = a.charAt(ai--) - '0' + carry;
            res[ri--] = (char) (sum % 2 + '0');
            carry = sum >>> 1;
        }
        while (bi >= 0) {
            int sum = b.charAt(bi--) - '0' + carry;
            res[ri--] = (char) (sum % 2 + '0');
            carry = sum >>> 1;
        }
        if (carry == 0) {
            return String.valueOf(res, 1, res.length - 1);
        }
        res[0] = '1';
        return String.valueOf(res);
    }
}
