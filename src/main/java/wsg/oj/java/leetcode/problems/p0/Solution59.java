package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 59. Spiral Matrix II (Medium)
 *
 * @author Kingen
 * @see Solution54
 * @see Solution885
 * @see <a href="https://leetcode-cn.com/problems/spiral-matrix-ii/">Spiral Matrix II</a>
 * @since 2021-07-11
 */
class Solution59 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_NN
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // di: the step of i; dj: the step of j
        // len: the count of unvisited elements in this direction
        // turns: times of turning
        int i = 0, j = -1, di = 0, dj = 1, len = n, turns = 0, value = 1;
        do {
            for (int k = 0; k < len; k++) {
                i += di;
                j += dj;
                res[i][j] = value++;
            }
            turns++;
            // turn right when reaching the end in this direction
            int temp = di;
            di = dj;
            dj = -temp;
            len = (n + n) - len - turns;
        } while (len > 0);
        return res;
    }
}
