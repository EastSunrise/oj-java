package wsg.oj.java.leetcode.problems.p0;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution238;

/**
 * 42. Trapping Rain Water (HARD)
 *
 * @author Kingen
 * @see Solution11
 * @see Solution238
 * @see Solution407
 * @see Solution755
 * @see <a href="https://leetcode-cn.com/problems/trapping-rain-water/">Trapping Rain Water</a>
 * @since 2021-07-18
 */
public class Solution42 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
