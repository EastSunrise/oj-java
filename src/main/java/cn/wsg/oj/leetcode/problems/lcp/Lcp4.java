package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * LCP 4. Broken Board Dominoes (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/broken-board-dominoes/">Broken Board Dominoes</a>
 */
public class Lcp4 implements Solution {

    public int domino(int n, int m, int[][] broken) {
        int[][] grid = new int[n][m];
        for (int[] b : broken) {
            grid[b[0]][b[1]] = -1;
        }
        return 0;
    }
}
