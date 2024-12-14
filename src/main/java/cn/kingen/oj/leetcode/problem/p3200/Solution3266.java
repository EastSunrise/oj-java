package cn.kingen.oj.leetcode.problem.p3200;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;
import static cn.kingen.oj.leetcode.util.MathUtils.fastPow;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/final-array-state-after-k-multiplication-operations-ii/">3266. Final Array State After K Multiplication Operations II</a>
 *
 * @author Kingen

 */
@Question(
    tags = {Tag.ARRAY, Tag.SIMULATION, Tag.HEAP_PRIORITY_QUEUE},
    difficulty = Difficulty.HARD,
    daily = "2024-12-14"
)
public class Solution3266 {

    @Complexity(time = "O(n*log(n)*log(M))", space = "O(n)", note = "M is the maximum of numbers")
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) {
            return nums;
        }
        int n = nums.length;

        // x[0] is the index of the number, x[1] is the number
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            Comparator.<long[], Long>comparing(x -> x[1]).thenComparing(x -> x[0]));
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            pq.offer(new long[]{i, nums[i]});
        }

        while (pq.element()[1] < max && k-- > 0) {
            long[] x = pq.remove();
            x[1] *= multiplier;
            pq.offer(x);
        }

        long power = fastPow(multiplier, k / n, MOD);
        k %= n;
        while (!pq.isEmpty()) {
            long[] x = pq.remove();
            x[1] = x[1] % MOD * power % MOD;
            if (k-- > 0) { // extra one operation
                x[1] = x[1] * multiplier % MOD;
            }
            nums[(int) x[0]] = (int) x[1];
        }
        return nums;
    }
}