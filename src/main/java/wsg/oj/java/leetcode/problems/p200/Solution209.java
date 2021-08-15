package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution76;

/**
 * 209. Minimum Size Subarray Sum (Medium)
 *
 * @author Kingen
 * @see Solution76
 * @see Solution325
 * @see Solution718
 * @see Solution1658
 * @see <a href="https://leetcode-cn.com/problems/minimum-size-subarray-sum/">Minimum Size Subarray
 * Sum</a>
 * @since 2021-07-12
 */
public class Solution209 implements Solution {

    /**
     * Slides a window.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int minSubArrayLen(int target, int[] nums) {
        // i: the left (inclusive) of the window
        // j: the right (exclusive) of the window
        int i = 0, j = 0, n = nums.length;
        int sum = 0, res = Integer.MAX_VALUE;
        while (true) {
            if (sum < target) {
                if (j == n) {
                    break;
                }
                sum += nums[j++];
            } else {
                res = Math.min(res, j - i);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
