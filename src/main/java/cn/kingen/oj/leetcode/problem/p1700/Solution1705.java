package cn.kingen.oj.leetcode.problem.p1700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-eaten-apples/">1705. Maximum Number of Eaten Apples</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution1705 {

    @Complexity(time = "O(n*log(n))", space = "O(n)")
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(n, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            if (apples[i] > 0) {
                pq.offer(new int[]{i + days[i], apples[i]});
            }
            while (!pq.isEmpty() && (pq.peek()[0] <= i || pq.peek()[1] == 0)) { // remove rotten apples
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.peek()[1]--;
                ans++;
            }
        }

        int d = n;
        while (!pq.isEmpty()) {
            int[] x = pq.poll();
            if (x[0] > d && x[1] > 0) {
                int cnt = Math.min(x[0] - d, x[1]);
                ans += cnt;
                d += cnt;
            }
        }
        return ans;
    }
}