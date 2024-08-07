package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/first-completely-painted-row-or-column/">2661. First Completely Painted Row or Column</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2133
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2482
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.MATRIX},
        difficulty = Difficulty.MEDIUM
)
public class Solution2661 {

    @Complexity(time = "O(mn)", space = "O(mn)")
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length, length = arr.length;
        int[] rowIndices = new int[length + 1], columnIndices = new int[length + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowIndices[mat[i][j]] = i;
                columnIndices[mat[i][j]] = j;
            }
        }
        int[] rowCount = new int[m], columnCount = new int[n];
        for (int k = 0; k < length; k++) {
            if (++rowCount[rowIndices[arr[k]]] == n) {
                return k;
            }
            if (++columnCount[columnIndices[arr[k]]] == m) {
                return k;
            }
        }
        return -1;
    }
}