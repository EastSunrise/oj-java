package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 457. Circular Array Loop (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/circular-array-loop/">Circular Array Loop</a>
 * @since 2021-07-09
 */
class Solution457 implements Solution {

    /**
     * Two pointers.
     */
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = i;
            do {
                slow = ((slow + nums[slow]) % len + len) % len;
                fast = ((fast + nums[fast]) % len + len) % len;
                fast = ((fast + nums[fast]) % len + len) % len;
            } while (slow != fast);
            // the length of the cycle is greater than 1
            if (((fast + nums[fast]) % len + len) % len != fast) {
                boolean positive = nums[fast] > 0;
                do {
                    fast = ((fast + nums[fast]) % len + len) % len;
                } while (nums[fast] > 0 == positive && fast != slow);
                if (fast == slow) {
                    return true;
                }
            }
            slow = i;
            while (nums[slow] != 0) {
                fast = ((slow + nums[slow]) % len + len) % len;
                nums[slow] = 0;
                slow = fast;
            }
        }
        return false;
    }
}
