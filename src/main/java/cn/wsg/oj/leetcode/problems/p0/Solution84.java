package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 84. Largest Rectangle in Histogram (HARD)
 *
 * @author Kingen
 * @see Solution85
 * @see Solution1793
 * @see <a href="https://leetcode-cn.com/problems/largest-rectangle-in-histogram/">Largest Rectangle
 * in Histogram</a>
 */
public class Solution84 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // the indices of the subarray in ascending order
        Deque<Integer> indices = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            while (!indices.isEmpty() && heights[indices.peek()] >= heights[i]) {
                // the height of current rectangle
                // that takes i as its right bound (exclusive)
                int height = heights[indices.pop()];
                // the left bound of the rectangle (inclusive)
                int left = indices.isEmpty() ? 0 : indices.peek() + 1;
                max = Math.max(max, height * (i - left));
            }
            indices.push(i);
        }
        while (!indices.isEmpty()) {
            int height = heights[indices.pop()];
            int left = indices.isEmpty() ? 0 : indices.peek() + 1;
            max = Math.max(max, height * (n - left));
        }
        return max;
    }
}
