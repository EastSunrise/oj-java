package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 441. Arranging Coins (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/arranging-coins/">Arranging Coins</a>
 * @since 2021-07-14
 */
class Solution441 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int arrangeCoins(int n) {
        long k = (long) Math.sqrt(2 * (long) n);
        return (int) (k * (k + 1) / 2 > (long) n ? k - 1 : k);
    }
}
