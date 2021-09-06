package wsg.oj.java.leetcode.problems.lcp;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * LCP 6. 拿硬币 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/na-ying-bi/">拿硬币</a>
 * @since 2021-07-28
 */
public class Lcp6 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int minCount(int[] coins) {
        int cnt = 0;
        for (int coin : coins) {
            cnt += (coin + 1) / 2;
        }
        return cnt;
    }
}
