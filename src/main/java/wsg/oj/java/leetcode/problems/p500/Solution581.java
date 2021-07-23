package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 581. Shortest Unsorted Continuous Subarray (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/">Shortest
 * Unsorted Continuous Subarray</a>
 * @since 2021-07-20
 */
class Solution581 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
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
