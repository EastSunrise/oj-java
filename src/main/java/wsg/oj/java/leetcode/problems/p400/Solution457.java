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
     * Uses a faster pointer and a slower pointer to find the cycle. Return true if the cycle
     * satisfies the requirements or set all to zeros.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = i;
            do {
                slow = ((slow + nums[slow]) % n + n) % n;
                fast = ((fast + nums[fast]) % n + n) % n;
                fast = ((fast + nums[fast]) % n + n) % n;
            } while (slow != fast);
            // the length of the cycle is greater than 1
            if (((fast + nums[fast]) % n + n) % n != fast) {
                boolean positive = nums[fast] > 0;
                do {
                    fast = ((fast + nums[fast]) % n + n) % n;
                } while (nums[fast] > 0 == positive && fast != slow);
                if (fast == slow) {
                    return true;
                }
            }
            slow = i;
            while (nums[slow] != 0) {
                fast = ((slow + nums[slow]) % n + n) % n;
                nums[slow] = 0;
                slow = fast;
            }
        }
        return false;
    }
}
