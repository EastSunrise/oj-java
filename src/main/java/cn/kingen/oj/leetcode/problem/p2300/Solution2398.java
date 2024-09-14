package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-robots-within-budget/">2398. Maximum Number of Robots Within Budget</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution239
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2040
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2071
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2064
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2187
 */
@Question(
        tags = {Tag.QUEUE, Tag.ARRAY, Tag.BINARY_SEARCH, Tag.PREFIX_SUM, Tag.SLIDING_WINDOW, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.HARD
)
public class Solution2398 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int ans = 0;
        long sum = 0;
        // store max charge time at the head of monotonically decreasing queue
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0, j = 0; j < n; j++) {
            sum += runningCosts[j];
            while (!deque.isEmpty() && chargeTimes[j] >= chargeTimes[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(j);
            while (i <= j && chargeTimes[deque.getFirst()] + (j - i + 1) * sum > budget) {
                sum -= runningCosts[i];
                if (i == deque.getFirst()) {
                    deque.pollFirst();
                }
                i++;
            } // find max length of subarray ending with j
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}