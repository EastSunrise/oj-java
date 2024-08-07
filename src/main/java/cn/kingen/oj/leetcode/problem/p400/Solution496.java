package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-i/">496. Next Greater Element I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution503
 * @see cn.kingen.oj.leetcode.problem.p500.Solution556
 * @see cn.kingen.oj.leetcode.problem.p700.Solution739
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2104
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2281
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2454
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2487
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2996
 */
@Question(
        tags = {Tag.STACK, Tag.ARRAY, Tag.HASH_TABLE, Tag.MONOTONIC_STACK},
        difficulty = Difficulty.EASY
)
public class Solution496 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Map<Integer, Integer> nextGreaterElements = new HashMap<>(n);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : nums2) {
            while (!deque.isEmpty() && deque.peek() <= num) {
                nextGreaterElements.put(deque.pop(), num);
            }
            deque.push(num);
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = nextGreaterElements.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}