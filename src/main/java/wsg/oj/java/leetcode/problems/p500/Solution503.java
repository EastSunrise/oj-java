package wsg.oj.java.leetcode.problems.p500;

import java.util.Arrays;
import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p400.Solution496;

/**
 * 503. Next Greater Element II (MEDIUM)
 *
 * @author Kingen
 * @see Solution496
 * @see Solution556
 * @see <a href="https://leetcode-cn.com/problems/next-greater-element-ii/">Next Greater Element
 * II</a>
 * @since 2021-07-20
 */
public class Solution503 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for (int num : nums) {
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
        }
        return res;
    }
}
