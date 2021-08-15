package wsg.oj.java.leetcode.problems.p1100;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1128. Number of Equivalent Domino Pairs (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/">Number of
 * Equivalent Domino Pairs</a>
 * @since 2021-07-27
 */
public class Solution1128 implements Solution {

    /**
     * @complexity T=O(n)
     * @complexity S=O(100)
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int[] counts = new int[100];
        for (int[] domino : dominoes) {
            int val = Math.min(domino[0] * 10 + domino[1], domino[1] * 10 + domino[0]);
            res += counts[val]++;
        }
        return res;
    }
}
