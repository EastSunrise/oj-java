package wsg.oj.java.leetcode.problems.lcp;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * LCP 28. 采购方案 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/4xy4Wx/">采购方案</a>
 * @since 2021-07-28
 */
public class Lcp28 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        long cnt = 0;
        while (left < right) {
            if (nums[right] > target - nums[left]) {
                right--;
            } else {
                cnt += right - left;
                left++;
            }
        }
        return (int) (cnt % 1_000_000_007);
    }
}
