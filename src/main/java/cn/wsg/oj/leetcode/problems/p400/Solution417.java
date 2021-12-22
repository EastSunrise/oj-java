package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/pacific-atlantic-water-flow/">Pacific Atlantic
 * Water Flow</a>
 */
class Solution417 implements Solution {

    /**
     * @see #DFS
     * @see Complexity#TIME_MN
     * @see Complexity#SPACE_MN
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        // dpp[i][j]: whether (i,j) is upstream of the Pacific.
        boolean[][] dpp = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            goUpStream(heights, dpp, i, 0, 0);
        }
        for (int j = 0; j < n; j++) {
            goUpStream(heights, dpp, 0, j, 0);
        }
        // dpp[i][j]: whether (i,j) is upstream of the Atlantic.
        boolean[][] dpa = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            goUpStream(heights, dpa, i, n - 1, 0);
        }
        for (int j = 0; j < n; j++) {
            goUpStream(heights, dpa, m - 1, j, 0);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dpp[i][j] && dpa[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private void goUpStream(int[][] heights, boolean[][] upstreams, int i, int j, int height) {
        if (i < 0 || j < 0 || i == heights.length || j == heights[0].length) {
            return;
        }
        if (heights[i][j] < height || upstreams[i][j]) {
            return;
        }
        upstreams[i][j] = true;
        height = heights[i][j];
        goUpStream(heights, upstreams, i - 1, j, height);
        goUpStream(heights, upstreams, i + 1, j, height);
        goUpStream(heights, upstreams, i, j - 1, height);
        goUpStream(heights, upstreams, i, j + 1, height);
    }
}
