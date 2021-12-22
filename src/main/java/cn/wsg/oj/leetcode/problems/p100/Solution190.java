package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution7;

/**
 * 190. Reverse Bits (Easy)
 *
 * @author Kingen
 * @see Solution7
 * @see Solution191
 * @see <a href="https://leetcode-cn.com/problems/reverse-bits/">Reverse Bits</a>
 */
public class Solution190 implements Solution {

    /**
     * @complexity T=O(32)
     * @see Complexity#SPACE_CONSTANT
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>>= 1;
        }
        return res;
    }
}
