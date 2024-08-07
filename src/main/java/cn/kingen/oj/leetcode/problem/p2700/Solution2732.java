package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-a-good-subset-of-the-matrix/">2732. Find a Good Subset of the Matrix</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.HASH_TABLE, Tag.MATRIX},
        difficulty = Difficulty.HARD
)
public class Solution2732 {

    @Complexity(time = "O(mn+k^2)", space = "O(k)", note = "k=2^n")
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int k = (int) Math.pow(2, n);
        int[] rows = new int[k];
        Arrays.fill(rows, -1);
        for (int i = 0; i < m; i++) {
            int mask = 0;
            for (int v : grid[i]) {
                mask = mask << 1 | v;
            }
            if (mask == 0) {
                return List.of(i);
            }
            rows[mask] = i;
        }
        for (int x = 0; x < k; x++) {
            if (rows[x] == -1) {
                continue;
            }
            for (int y = 0; y < x; y++) {
                if (rows[y] == -1 || (x & y) != 0) {
                    continue;
                }
                int i = rows[x], j = rows[y];
                return i < j ? List.of(i, j) : List.of(j, i);
            }
        }
        return List.of();
    }
}