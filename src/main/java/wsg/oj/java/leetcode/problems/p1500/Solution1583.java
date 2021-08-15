package wsg.oj.java.leetcode.problems.p1500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1583. Count Unhappy Friends (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/count-unhappy-friends/">Count Unhappy Friends</a>
 * @since 2021-07-27
 */
public class Solution1583 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_NN
     */
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] pfs = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                pfs[i][preferences[i][j]] = j;
            }
        }
        int[] prs = new int[n];
        for (int[] pair : pairs) {
            prs[pair[0]] = pair[1];
            prs[pair[1]] = pair[0];
        }
        int res = 0;
        for (int x = 0; x < n; x++) {
            int y = prs[x];
            int idx = pfs[x][y];
            for (int i = 0; i < idx; i++) {
                int u = preferences[x][i];
                int v = prs[u];
                if (pfs[u][x] < pfs[u][v]) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
