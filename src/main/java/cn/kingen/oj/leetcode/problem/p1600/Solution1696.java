package cn.kingen.oj.leetcode.problem.p1600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/jump-game-vi/">1696. Jump Game VI</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution239
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1871
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2297
 * @see cn.kingen.oj.leetcode.problem.p2800.Solution2836
 */
@Question(
        tags = {Tag.QUEUE, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.MONOTONIC_QUEUE, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution1696 {

    @Complexity(time = "O(n)", space = "O(k)")
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<int[]> deque = new ArrayDeque<>(k);
        deque.offerLast(new int[]{0, nums[0]});
        for (int i = 1; i < n; i++) {
            int j = Math.max(0, i - k);
            while (!deque.isEmpty() && deque.peekFirst()[0] < j) {
                deque.pollFirst();
            }
            int sum = deque.getFirst()[1] + nums[i];
            while (!deque.isEmpty() && deque.peekLast()[1] <= sum) {
                deque.pollLast();
            }
            deque.offerLast(new int[]{i, sum});
        }
        return deque.getLast()[1];
    }
}