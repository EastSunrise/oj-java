package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution152;
import wsg.oj.java.leetcode.problems.p500.Solution560;

/**
 * 713. Subarray Product Less Than K (MEDIUM)
 *
 * @author Kingen
 * @see Solution152
 * @see Solution325
 * @see Solution560
 * @see Solution1099
 * @see <a href="https://leetcode-cn.com/problems/subarray-product-less-than-k/">Subarray Product
 * Less Than K</a>
 * @since 2021-07-26
 */
public class Solution713 implements Solution {

    /**
     * Slides a window.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int left = 0, right = 0, n = nums.length;
        int product = 1, count = 0;
        while (right < n) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
            }
            // the subarray that ends with nums[right]
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
