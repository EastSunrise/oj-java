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

    public int trap(int[] height) {
        int left = 0, n = height.length - 1;
        while (left < n && height[left] <= height[left + 1]) {
            left++;
        }
        int water = 0;
        while (true) {
            int bot = left + 1;
            while (bot < n && height[bot] >= height[bot + 1]) {
                bot++;
            }
            if (bot >= n) {
                break;
            }
            int right = bot + 1;
            while (right < n && height[right] <= height[right + 1]) {
                right++;
            }
            int h = Math.min(height[left], height[right]);
            for (int i = left + 1; i < right; i++) {
                if (height[i] < h) {
                    water += h - height[i];
                    height[i] = h;
                }
            }
            left = right;
        }
        // keep raining
        return water > 0 ? water + trap(height) : water;
    }
}
