package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashMap;
import java.util.Map;

/**
 * LCP 20. 快速公交 (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/meChtZ/">快速公交</a>
 */
public class Lcp20 implements Solution {

    Map<Long, Long> times = new HashMap<>();

    /**
     * @see #DFS
     */
    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
        return (int) (dfs(target, inc, dec, jump, cost, jump.length) % MOD);
    }

    private long dfs(long target, int inc, int dec, int[] jump, int[] cost, int n) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return inc;
        }
        if (times.containsKey(target)) {
            return times.get(target);
        }

        long min = inc * target;
        for (int i = 0; i < n; i++) {
            long prev = target / jump[i], step = target % jump[i];
            if (step != 0) {
                long t = dfs(prev + 1, inc, dec, jump, cost, n) + cost[i] + (jump[i] - step) * dec;
                min = Math.min(min, t);
            }
            min = Math.min(min, dfs(prev, inc, dec, jump, cost, n) + cost[i] + step * inc);
        }
        times.put(target, min);
        return min;
    }
}
