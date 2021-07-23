package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p600.Solution657;

/**
 * 547. Number of Provinces (MEDIUM)
 *
 * @author Kingen
 * @see Solution323
 * @see Solution657
 * @see Solution734
 * @see Solution737
 * @see Solution1101
 * @see <a href="https://leetcode-cn.com/problems/number-of-provinces/">Number of Provinces</a>
 * @since 2021-07-20
 */
public class Solution547 implements Solution {

    /**
     * @see #DFS
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (isConnected[i][i] == 1) {
                connect(isConnected, i);
                provinces++;
            }
        }
        return provinces;
    }

    private void connect(int[][] isConnected, int city) {
        isConnected[city][city] = -1;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[city][i] == 1 && isConnected[i][i] == 1) {
                // connected
                connect(isConnected, i);
            }
        }
    }
}
