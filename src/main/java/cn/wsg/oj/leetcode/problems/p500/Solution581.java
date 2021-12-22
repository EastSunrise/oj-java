package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 581. Shortest Unsorted Continuous Subarray (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/">Shortest
 * Unsorted Continuous Subarray</a>
 */
public class Solution581 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int i = 1;
        // find nums[0,i-1] in ascending order
        while (i < n && nums[i - 1] <= nums[i]) {
            i++;
        }
        if (i == n) {
            return 0;
        }
        int min = nums[i];
        for (int j = i + 1; j < n; j++) {
            min = Math.min(min, nums[j]);
        }
        int left = 0;
        while (nums[left] <= min) {
            left++;
        }
        i = n - 2;
        // find nums[i+1,n-1] in ascending order
        while (nums[i] <= nums[i + 1]) {
            i--;
        }
        int max = nums[i];
        for (int j = 0; j < i; j++) {
            max = Math.max(max, nums[j]);
        }
        int right = n - 1;
        while (nums[right] >= max) {
            right--;
        }
        return right - left + 1;
    }
}
