package wsg.oj.java.leetcode.problems.p600;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 611. Valid Triangle Number (MEDIUM)
 *
 * @author Kingen
 * @see Solution259
 * @see <a href="https://leetcode-cn.com/problems/valid-triangle-number/">Valid Triangle Number</a>
 * @since 2021-07-23
 */
class Solution611 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    // nums[i,j-1], nums[j], nums[k]
                    count += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
