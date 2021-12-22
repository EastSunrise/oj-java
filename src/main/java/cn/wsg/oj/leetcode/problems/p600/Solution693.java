package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution191;

/**
 * 693. Binary Number with Alternating Bits (EASY)
 *
 * @author Kingen
 * @see Solution191
 * @see <a href="https://leetcode-cn.com/problems/binary-number-with-alternating-bits/">Binary
 * Number with Alternating Bits</a>
 */
public class Solution693 implements Solution {

    /**
     * @complexity T=(32)
     * @complexity S=O(1)
     */
    public boolean hasAlternatingBits(int n) {
        int bit = n & 1;
        n >>= 1;
        while (n > 0) {
            if ((n & 1) == bit) {
                return false;
            }
            bit = bit ^ 1;
            n >>= 1;
        }
        return true;
    }
}
