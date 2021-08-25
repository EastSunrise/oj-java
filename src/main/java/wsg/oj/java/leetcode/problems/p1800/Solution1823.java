package wsg.oj.java.leetcode.problems.p1800;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1823. Find the Winner of the Circular Game (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/">Find the
 * Winner of the Circular Game</a>
 * @since 2021-07-27
 */
public class Solution1823 implements Solution {

    /**
     * Josephus problem.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int findTheWinner(int n, int k) {
        int winner = 0;
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner + 1;
    }
}
