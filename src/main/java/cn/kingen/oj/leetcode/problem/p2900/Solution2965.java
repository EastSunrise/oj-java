package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-missing-and-repeated-values/">2965. Find Missing and Repeated Values</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.MATH, Tag.MATRIX},
        difficulty = Difficulty.EASY
)
public class Solution2965 {

    @Complexity(time = "O(n^2)", space = "O(1)")
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = i * n + j + 1;
                while (grid[i][j] != k) {
                    int z = grid[i][j], x = (z - 1) / n, y = (z - 1) % n;
                    if (grid[x][y] == z) { // duplicate value
                        a = z;
                        b = k;
                        break;
                    } else { // swap values to satisfy grid[x][y] = z = x*n+j+1
                        grid[i][j] = grid[x][y];
                        grid[x][y] = z;
                    }
                }
            }
        }
        return new int[]{a, b};
    }
}