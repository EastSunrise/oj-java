package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-seconds-to-make-mountain-height-zero/">3296. Minimum Number of Seconds to Make Mountain Height Zero</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.MATH, Tag.BINARY_SEARCH, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM,
        contest = 416
)
public class Solution3296 {

    @Complexity(time = "O(n*log(U))", space = "O(1)")
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int max = 0;
        for (int workerTime : workerTimes) {
            max = Math.max(max, workerTime);
        }

        long left = 0, right = (long) mountainHeight * (mountainHeight + 1) / 2 * max;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canFinish(mountainHeight, workerTimes, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int height, int[] times, long limit) {
        for (int time : times) {
            int k = ((int) Math.sqrt((double) limit / time * 8 + 1) - 1) / 2;
            height -= k;
            if (height <= 0) {
                return true;
            }
        }
        return false;
    }

    @Complexity(time = "O(H*log(n))", space = "O(n)")
    public long minNumberOfSeconds2(int mountainHeight, int[] workerTimes) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        for (int workerTime : workerTimes) {
            pq.offer(new long[]{workerTime, workerTime, 1});
        }
        long ans = 0;
        while (mountainHeight > 0) {
            mountainHeight--;
            long[] w = pq.remove();
            ans = Math.max(ans, w[0]);

            w[0] += w[1] * (++w[2]);
            pq.offer(w);
        }
        return ans;
    }
}