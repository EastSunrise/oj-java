package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution231;

/**
 * 191. Number of 1 Bits (Easy)
 *
 * @author Kingen
 * @see Solution190
 * @see Solution231
 * @see Solution338
 * @see Solution401
 * @see Solution461
 * @see Solution693
 * @see Solution762
 * @see <a href="https://leetcode-cn.com/problems/number-of-1-bits/">Number of 1 Bits</a>
 */
public class Solution191 implements Solution {

    /**
     * @complexity T=O(32)
     * @see Complexity#SPACE_CONSTANT
     */
    public int hammingWeight(int n) {
        int weight = 0;
        for (int i = 0; i < 32; i++) {
            weight += n & 1;
            n >>= 1;
        }
        return weight;
    }
}
