package cn.wsg.oj.leetcode.problems.interview.ch17;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 面试题 17.10. Find Majority Element LCCI (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/find-majority-element-lcci/">Find Majority Element
 * LCCI</a>
 */
public class Interview10 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        int majority = nums[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == majority) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                majority = nums[i];
                count = 1;
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == majority) {
                count++;
            }
        }
        return count > n - count ? majority : -1;
    }
}
