package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution191;

/**
 * 461. Hamming Distance (Easy)
 *
 * @author Kingen
 * @see Solution191
 * @see Solution477
 * @see <a href="https://leetcode-cn.com/problems/hamming-distance/">Hamming Distance</a>
 */
public class Solution461 implements Solution {

    /**
     * @complexity T=O(32)
     * @complexity S=O(1)
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
