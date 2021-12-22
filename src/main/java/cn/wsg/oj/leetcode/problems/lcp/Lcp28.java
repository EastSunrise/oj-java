package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * LCP 28. 采购方案 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/4xy4Wx/">采购方案</a>
 */
public class Lcp28 implements Solution {

    /**
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_CONSTANT
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
        return (int) (cnt % MOD);
    }
}
