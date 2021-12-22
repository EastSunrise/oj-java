package cn.wsg.oj.leetcode.problems.p1800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1823. Find the Winner of the Circular Game (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/">Find the
 * Winner of the Circular Game</a>
 */
public class Solution1823 implements Solution {

    /**
     * Josephus problem.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int findTheWinner(int n, int k) {
        int winner = 0;
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner + 1;
    }
}
