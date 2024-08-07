package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/maximum-strictly-increasing-cells-in-a-matrix/">2713. Maximum Strictly Increasing Cells in a Matrix</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2328
 */
@Question(
        tags = {Tag.MEMOIZATION, Tag.ARRAY, Tag.BINARY_SEARCH, Tag.DYNAMIC_PROGRAMMING, Tag.MATRIX, Tag.SORTING},
        difficulty = Difficulty.HARD
)
public class Solution2713 {

    @Complexity(time = "O(mn*log(mn))", space = "O(mn)")
    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        TreeMap<Integer, List<int[]>> pos = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pos.computeIfAbsent(mat[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        int ans = 0;
        // the max increasing cells in each row and column
        int[] row = new int[m], col = new int[n];
        for (List<int[]> ps : pos.values()) {
            int[] max = new int[ps.size()];
            for (int k = 0; k < ps.size(); k++) { // calculate from those strictly less than current value
                int[] p = ps.get(k);
                int i = p[0], j = p[1];
                max[k] = Math.max(row[i], col[j]) + 1;
                ans = Math.max(ans, max[k]);
            }
            for (int k = 0; k < ps.size(); k++) {
                int[] p = ps.get(k);
                int i = p[0], j = p[1];
                row[i] = Math.max(row[i], max[k]);
                col[j] = Math.max(col[j], max[k]);
            }
        }
        return ans;
    }
}