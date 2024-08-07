package cn.kingen.oj.leetcode.problem.p1700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/find-kth-largest-xor-coordinate-value/">1738. Find Kth Largest XOR Coordinate Value</a>
 *
 * @author Kingen
 */
@Question(tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.DIVIDE_AND_CONQUER, Tag.MATRIX, Tag.PREFIX_SUM, Tag.QUICKSELECT, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE}, difficulty = Difficulty.MEDIUM)
public class Solution1738 {

    @Complexity(time = "O(m*n*log(k))", space = "O(k)")
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    matrix[i][j] ^= matrix[i - 1][j];
                }
                if (j > 0) {
                    matrix[i][j] ^= matrix[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    matrix[i][j] ^= matrix[i - 1][j - 1];
                }
                pq.offer(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.remove();
    }
}