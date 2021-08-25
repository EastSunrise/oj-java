package wsg.oj.java.leetcode.problems.p300;

import java.util.Comparator;
import java.util.PriorityQueue;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p600.Solution668;

/**
 * 378. Kth Smallest Element in a Sorted Matrix (Medium)
 *
 * @author Kingen
 * @see Solution373
 * @see Solution668
 * @see Solution719
 * @see Solution786
 * @see <a href="https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/">Kth
 * Smallest Element in a Sorted Matrix</a>
 * @since 2021-07-06
 */
public class Solution378 implements Solution {

    /**
     * Merge sort.
     *
     * @see wsg.oj.java.Complexity#TIME_M_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int kthSmallest(int[][] matrix, int m) {
        int n = matrix.length;
        PriorityQueue<int[]> candidates = new PriorityQueue<>(n,
            Comparator.comparingInt(arr -> matrix[arr[0]][arr[1]]));
        for (int j = 0; j < n; j++) {
            candidates.add(new int[]{0, j});
        }
        while (true) {
            int[] ij = candidates.remove();
            if (--m == 0) {
                return matrix[ij[0]][ij[1]];
            }
            if (ij[0] < n - 1) {
                // there are numbers remaining in a column
                candidates.add(new int[]{ij[0] + 1, ij[1]});
            }
        }
    }

    /**
     * @complexity T=O(n*log(d)), d=max-min
     * @complexity S=O(1)
     * @see #BINARY_SEARCH
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int midVal = left + (right - left) / 2;
            int count = binarySearchAndCount(matrix, midVal);
            if (count < k) {
                left = midVal + 1;
            } else {
                right = midVal;
            }
        }
        return right;
    }

    /**
     * Counts number of elements less than or equal to the target.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     */
    private int binarySearchAndCount(int[][] matrix, int target) {
        // from the left-bottom corner
        int i = matrix.length - 1, j = 0, count = 0;
        while (i >= 0 && j < matrix.length) {
            if (matrix[i][j] <= target) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}
