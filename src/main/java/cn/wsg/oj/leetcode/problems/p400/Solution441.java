package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 441. Arranging Coins (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/arranging-coins/">Arranging Coins</a>
 */
class Solution441 implements Solution {

    /**
     * @see Complexity#TIME_CONSTANT
     * @see Complexity#SPACE_CONSTANT
     */
    public int arrangeCoins(int n) {
        long k = (long) Math.sqrt(2 * (long) n);
        return (int) (k * (k + 1) / 2 > (long) n ? k - 1 : k);
    }
}
