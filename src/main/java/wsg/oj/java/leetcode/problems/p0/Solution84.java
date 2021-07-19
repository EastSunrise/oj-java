package wsg.oj.java.leetcode.problems.p0;

import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 84. Largest Rectangle in Histogram (HARD)
 *
 * @author Kingen
 * @see Solution85
 * @see Solution1793
 * @see <a href="https://leetcode-cn.com/problems/largest-rectangle-in-histogram/">Largest Rectangle
 * in Histogram</a>
 * @since 2021-07-19
 */
class Solution84 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // heights[indices[i-1]] < heights[indices[i]]
        Stack<Integer> indices = new Stack<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            while (!indices.isEmpty() && heights[indices.peek()] >= heights[i]) {
                // the height of current rectangle
                // that takes i as its right bound
                int height = heights[indices.pop()];
                // the left bound of the rectangle
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
