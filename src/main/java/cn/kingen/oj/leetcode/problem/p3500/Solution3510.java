package cn.kingen.oj.leetcode.problem.p3500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/minimum-pair-removal-to-sort-array-ii/">3510. Minimum Pair Removal to Sort
 * Array II</a>
 *
 * @author Kingen
 */
@Question(
    difficulty = Difficulty.HARD,
    contest = 444
)
public class Solution3510 {

    @Complexity(time = "O(n*log(n))", space = "O(n)")
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n], next = new int[n];
        long[] values = new long[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
            values[i] = nums[i];
        }

        // count of decreasing pairs
        int decrease = 0;
        // (i, j, nums[i]+nums[j], update times)
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            Comparator.<long[]>comparingLong(a -> a[2]).thenComparingLong(a -> a[0]));
        for (int i = 1; i < n; i++) {
            pq.offer(new long[]{i - 1, i, values[i - 1] + values[i], 0, 0});
            if (nums[i - 1] > nums[i]) {
                decrease++;
            }
        }

        int ans = 0;
        int[] updateTimes = new int[n];
        while (!pq.isEmpty() && decrease > 0) {
            long[] pair = pq.poll();
            int i = (int) pair[0], j = (int) pair[1], pi = prev[i], nj = next[j];
            if (pair[3] < updateTimes[i] || pair[4] < updateTimes[j]) { // delay delete invalid pair
                continue;
            }
            if (pi >= 0 && values[pi] > values[i]) {
                decrease--;
            }
            if (values[i] > values[j]) {
                decrease--;
            }
            if (next[j] < n && values[j] > values[nj]) {
                decrease--;
            }

            ans++;
            values[i] = pair[2]; // replace with sum
            updateTimes[i]++;
            updateTimes[j]++;
            next[i] = nj; // unlink j
            if (nj < n) {
                prev[nj] = i;
            }

            if (pi >= 0) {
                pq.offer(new long[]{pi, i, values[pi] + values[i], updateTimes[pi], updateTimes[i]});
            }
            if (nj < n) {
                pq.offer(new long[]{i, nj, values[i] + values[nj], updateTimes[i], updateTimes[nj]});
            }

            if (pi >= 0 && values[pi] > values[i]) {
                decrease++;
            }
            if (nj < n && values[i] > values[nj]) {
                decrease++;
            }
        }
        return ans;
    }
}