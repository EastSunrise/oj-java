package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix (Medium)
 *
 * @author Kingen
 * @see Solution59
 * @see Solution885
 * @see <a href="https://leetcode-cn.com/problems/spiral-matrix/">Spiral Matrix</a>
 */
public class Solution54 implements Solution {

    /**
     * Changes the length of numbers to be traversed each turn.
     *
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_MN
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);
        // di: the step of i; dj: the step of j
        // len: the count of unvisited elements in this direction
        // turns: times of turning
        int i = 0, j = -1, di = 0, dj = 1, len = n, turns = 0;
        do {
            for (int k = 0; k < len; k++) {
                i += di;
                j += dj;
                res.add(matrix[i][j]);
            }
            turns++;
            // turn right when reaching the end in this direction
            int temp = di;
            di = dj;
            dj = -temp;
            len = (m + n) - len - turns;
        } while (len > 0);
        return res;
    }
}
