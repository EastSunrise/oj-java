package wsg.oj.java.leetcode.problems.p1200;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1267. Count Servers that Communicate (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/count-servers-that-communicate/">Count Servers
 * that Communicate</a>
 * @since 2021-07-27
 */
public class Solution1267 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_M_PLUS_N
     */
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) {
                    count++;
                }
            }
        }
        return count;
    }
}
