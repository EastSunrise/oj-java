package wsg.oj.java.leetcode.problems.p400;

import java.util.Stack;
import java.util.TreeMap;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 456. 132 Pattern (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/132-pattern/">132 Pattern</a>
 * @since 2021-07-08
 */
public class Solution456 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public boolean find132pattern(int[] nums) {
        int leftMin = nums[0];
        TreeMap<Integer, Integer> right = new TreeMap<>();
        for (int i = 2; i < nums.length; i++) {
            right.put(nums[i], right.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 1, len = nums.length - 1; i < len; i++) {
            if (nums[i] > leftMin) {
                Integer key = right.higherKey(leftMin);
                if (key != null && key < nums[i]) {
                    return true;
                }
            } else {
                leftMin = nums[i];
            }
            int count = right.get(nums[i + 1]);
            if (count == 1) {
                right.remove(nums[i + 1]);
            } else {
                right.put(nums[i + 1], count - 1);
            }
        }
        return false;
    }

    /**
     * Uses a monotonically decreasing stack to store the candidates of the middle one.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public boolean find132pattern2(int[] nums) {
        int len = nums.length;
        // store the candidates of the middle one
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[len - 1]);
        // the right one
        int right = Integer.MIN_VALUE;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < right) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                right = stack.pop();
            }
            if (nums[i] > right) {
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
