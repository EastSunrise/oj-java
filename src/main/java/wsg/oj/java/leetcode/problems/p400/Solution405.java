package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 405. Convert a Number to Hexadecimal (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/">Convert a Number
 * to Hexadecimal</a>
 * @since 2021-07-14
 */
public class Solution405 implements Solution {

    /**
     * @complexity T=O(b/4), b=bits of the value
     * @complexity S=O(b/4)
     * @see Integer#toHexString(int)
     */
    public String toHex(int num) {
        return toNRadix(num, 4, 0xf);
    }
}
