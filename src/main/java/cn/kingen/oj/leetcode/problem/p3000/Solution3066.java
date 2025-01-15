package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/minimum-operations-to-exceed-threshold-value-ii/">3066. Minimum Operations to Exceed Threshold Value II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2208

 */
@Question(
        tags = {Tag.ARRAY, Tag.SIMULATION, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM,
        daily = "2025-01-15"
)
public class Solution3066 {

    @Complexity(time = "O(n*log(n))", space = "O(n)")
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer((long) num);
        }

        int ans = 0;
        while (pq.size() >= 2 && pq.element() < k) {
            long x = pq.remove();
            long y = pq.remove();
            pq.offer((x << 1) + y);
            ans++;
        }
        return ans;
    }
}