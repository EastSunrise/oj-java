package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/sort-matrix-by-diagonals/">3446. Sort Matrix by Diagonals</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1300.Solution1329

 */
@Question(
        tags = {Tag.ARRAY, Tag.MATRIX, Tag.SORTING},
        difficulty = Difficulty.MEDIUM,
        contest = 436
)
public class Solution3446 {

    @Complexity(time = "O(n*n*log(n))", space = "O(n)")
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int[] diagonals = new int[n];
        for (int k = 0; k < n; k++) {
            int size = 0;
            for (int i = k, j = 0; i < n; i++, j++) {
                diagonals[size++] = grid[i][j];
            }
            Arrays.sort(diagonals, 0, size);
            for (int i = k, j = 0; i < n; i++, j++) {
                grid[i][j] = diagonals[--size];
            }
        }
        for (int k = 1; k < n; k++) {
            int size = 0;
            for (int i = 0, j = k; j < n; i++, j++) {
                diagonals[size++] = grid[i][j];
            }
            Arrays.sort(diagonals, 0, size);
            for (int i = n - 1 - k, j = n - 1; i >= 0; i--, j--) {
                grid[i][j] = diagonals[--size];
            }
        }
        return grid;
    }
}