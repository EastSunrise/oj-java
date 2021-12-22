package cn.wsg.oj.leetcode.problems.p1200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1267. Count Servers that Communicate (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/count-servers-that-communicate/">Count Servers
 * that Communicate</a>
 */
public class Solution1267 implements Solution {

    /**
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_M_PLUS_N
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
