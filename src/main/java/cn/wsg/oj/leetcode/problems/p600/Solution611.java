package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 611. Valid Triangle Number (MEDIUM)
 *
 * @author Kingen
 * @see Solution259
 * @see <a href="https://leetcode-cn.com/problems/valid-triangle-number/">Valid Triangle Number</a>
 */
public class Solution611 implements Solution {

    /**
     * @see Complexity#TIME_NN
     * @see Complexity#SPACE_CONSTANT
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
