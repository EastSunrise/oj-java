package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/">698. Partition to K Equal Sum Subsets</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution416
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2305
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2025
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2397
 */
@Question(
    tags = {Tag.BIT_MANIPULATION, Tag.MEMOIZATION, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.BACKTRACKING, Tag.BITMASK},
    difficulty = Difficulty.MEDIUM
)
public class Solution698 {

    @Complexity(time = "O(n*2^n)", space = "O(2^n)")
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }

        Arrays.sort(nums);
        int target = sum / k;
        int[] buckets = new int[k];
        Arrays.fill(buckets, target);
        return dfs(buckets, nums, nums.length - 1);
    }

    private boolean dfs(int[] buckets, int[] nums, int i) {
        if (i < 0) {
            return true;
        }
        for (int j = 0; j < buckets.length; j++) {
            if (buckets[j] >= nums[i]) {
                buckets[j] -= nums[i];
                if (dfs(buckets, nums, i - 1)) {
                    return true;
                }
                buckets[j] += nums[i];
            }
        }
        return false;
    }
}