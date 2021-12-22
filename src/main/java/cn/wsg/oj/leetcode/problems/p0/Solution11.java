package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 11. Container With Most Water (Medium)
 *
 * @author Kingen
 * @see Solution42
 * @see <a href="https://leetcode-cn.com/problems/container-with-most-water/">Container With Most
 * Water</a>
 */
public class Solution11 implements Solution {

    /**
     * Uses two pointers from both sides to find a possible area.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            int hl = height[left], hr = height[right];
            if (hl < hr) {
                // find next element higher than hl and calculate the area with hr
                do {
                    left++;
                } while (left < right && height[left] <= hl);
                max = Math.max(Math.min(height[left], hr) * (right - left), max);
            } else {
                // find next element higher than hr and calculate the area with hl
                do {
                    right--;
                } while (left < right && height[right] <= hr);
                max = Math.max(Math.min(hl, height[right]) * (right - left), max);
            }
        }
        return max;
    }
}
