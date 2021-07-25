package wsg.oj.java.leetcode.problems.p600;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p400.Solution416;

/**
 * 698. Partition to K Equal Sum Subsets (MEDIUM)
 *
 * @author Kingen
 * @see Solution416
 * @see <a href="https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/">Partition to K
 * Equal Sum Subsets</a>
 * @since 2021-07-23
 */
public class Solution698 implements Solution {

    /**
     * @see #BACKTRACKING
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        int[] buckets = new int[k];
        Arrays.fill(buckets, sum / k);
        return canPartition(buckets, nums, nums.length - 1);
    }

    private boolean canPartition(int[] buckets, int[] nums, int i) {
        if (i < 0) {
            return true;
        }
        for (int j = 0; j < buckets.length; j++) {
            if (buckets[j] >= nums[i]) {
                buckets[j] -= nums[i];
                if (canPartition(buckets, nums, i - 1)) {
                    return true;
                }
                buckets[j] += nums[i];
            }
        }
        return false;
    }
}
