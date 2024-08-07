package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-ii/">503. Next Greater Element II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution496
 * @see cn.kingen.oj.leetcode.problem.p500.Solution556
 */
@Question(
        tags = {Tag.STACK, Tag.ARRAY, Tag.MONOTONIC_STACK},
        difficulty = Difficulty.MEDIUM
)
public class Solution503 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for (int num : nums) {
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                ans[stack.pop()] = num;
            }
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }
}