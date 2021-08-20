package wsg.oj.java.leetcode.problems.p1300;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1337. The K Weakest Rows in a Matrix (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/">The K Weakest
 * Rows in a Matrix</a>
 * @since 2021-07-27
 */
public class Solution1337 implements Solution {

    /**
     * @complexity T=O(m*log{n}+m*log{m})
     * @complexity S=O(m)
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new PriorityQueue<>(
            Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mat[i][mid] == 1) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            queue.offer(new int[]{left, i});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove()[1];
        }
        return res;
    }
}
