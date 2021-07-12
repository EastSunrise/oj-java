package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution7;

/**
 * 190. Reverse Bits (Easy)
 *
 * @author Kingen
 * @see Solution7
 * @see Solution191
 * @see <a href="https://leetcode-cn.com/problems/reverse-bits/">Reverse Bits</a>
 * @since 2021-07-12
 */
public class Solution190 implements Solution {

    /**
     * @complexity T=O(32)
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 31; i++) {
            res = (res << 1) + (n & 1);
            n >>>= 1;
        }
        return res;
    }
}
