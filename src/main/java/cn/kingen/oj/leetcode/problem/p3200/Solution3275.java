package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/k-th-nearest-obstacle-queries/">3275. K-th Nearest Obstacle Queries</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p900.Solution973
 */
@Question(
        difficulty = Difficulty.MEDIUM
)
public class Solution3275 {

    @Complexity(time = "O(n*log(k))", space = "O(k)")
    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            pq.offer(Math.abs(query[0]) + Math.abs(query[1]));
            if (pq.size() > k) {
                pq.poll();
            }
            ans[i] = pq.size() >= k ? pq.element() : -1;
        }
        return ans;
    }

}