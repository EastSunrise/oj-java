package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static cn.kingen.oj.leetcode.util.ArrayUtils.DIRECTIONS;

/**
 * <a href="https://leetcode.cn/problems/making-a-large-island/">827. Making A Large Island</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.UNION_FIND, Tag.ARRAY, Tag.MATRIX},
        difficulty = Difficulty.HARD
)
public class Solution827 {

    @Complexity(time = "O(n^2)", space = "O(n^2)")
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int p = 1;
        int[][] root = new int[n][n];
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && root[i][j] == 0) {
                    sizes.add(dfs(grid, root, i, j, p));
                    p++;
                }
            }
        }

        int ans = 0;
        Set<Integer> connected = new HashSet<>(4);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    connected.clear();
                    int size = 0;
                    for (int[] d : DIRECTIONS) {
                        int x = i + d[0], y = j + d[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && root[x][y] > 0) {
                            if (connected.add(root[x][y])) {
                                size += sizes.get(root[x][y] - 1);
                            }
                        }
                    }
                    ans = Math.max(ans, size + 1);
                }
            }
        }
        return ans == 0 ? n * n : ans;
    }

    /**
     * @param p the root of the island, positive integer
     * @return size of the island
     */
    private int dfs(int[][] grid, int[][] root, int i, int j, int p) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || root[i][j] != 0) {
            return 0;
        }
        root[i][j] = p;
        int cnt = 1;
        for (int[] d : DIRECTIONS) {
            cnt += dfs(grid, root, i + d[0], j + d[1], p);
        }
        return cnt;
    }
}