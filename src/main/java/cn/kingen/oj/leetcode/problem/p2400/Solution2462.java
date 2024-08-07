package cn.kingen.oj.leetcode.problem.p2400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/total-cost-to-hire-k-workers/">2462. Total Cost to Hire K Workers</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution253
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2532
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.SIMULATION, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution2462 {

    @Complexity(time = "O((c+k)*log{c})", space = "O(c)", note = "c is candidates")
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> front = new PriorityQueue<>();
        PriorityQueue<Integer> back = new PriorityQueue<>();
        int i = 0, j = costs.length - 1;
        while (i < candidates) {
            front.offer(costs[i++]);
        }
        while (j >= i && back.size() < candidates) {
            back.offer(costs[j--]);
        }

        long ans = 0;
        while (k-- > 0) {
            if (front.isEmpty()) {
                ans += back.remove();
            } else if (back.isEmpty()) {
                ans += front.remove();
            } else if (front.peek() <= back.peek()) { // pick from front candidates
                ans += front.poll();
                if (i <= j) {
                    front.offer(costs[i++]);
                }
            } else { // pick from back candidates
                ans += back.poll();
                if (j >= i) {
                    back.offer(costs[j--]);
                }
            }
        }
        return ans;
    }
}