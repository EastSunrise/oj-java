package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * LCP 6. 拿硬币 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/na-ying-bi/">拿硬币</a>
 */
public class Lcp6 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int minCount(int[] coins) {
        int cnt = 0;
        for (int coin : coins) {
            cnt += (coin + 1) / 2;
        }
        return cnt;
    }
}
