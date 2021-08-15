package wsg.oj.java.leetcode.problems.p900;

import java.util.Deque;
import java.util.LinkedList;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 962. Maximum Width Ramp (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/maximum-width-ramp/">Maximum Width Ramp</a>
 * @since 2021-07-27
 */
public class Solution962 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        // indices of numbers in descending order
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }
        int max = 0;
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[j] >= nums[stack.peek()]) {
                max = Math.max(max, j - stack.pop());
            }
        }
        return max;
    }
}
