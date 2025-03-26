package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/paint-house-iv/">3429. Paint House IV</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1400.Solution1473

 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM,
        contest = 433
)
public class Solution3429 {

    private static final int[][] MAP = new int[][]{
            {},
            {3, 5, 6},
            {3, 6, 7},
            {1, 2, 7},
            {},
            {1, 6, 7},
            {1, 2, 5},
            {2, 3, 5},
            {}
    };

    @Complexity(time = "O(C*C*n)", space = "O(C)", note = "C is 9")
    public long minCost(int n, int[][] cost) {
        int m = n >> 1;
        long[] cur = new long[9], next = new long[9], tmp;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 9; j++) {
                if (MAP[j].length == 0) {
                    continue;
                }
                next[j] = Long.MAX_VALUE;
                for (int p : MAP[j]) {
                    next[j] = Math.min(next[j], cur[p]);
                }
                next[j] += cost[i][j / 3] + cost[n - 1 - i][j % 3];
            }
            tmp = cur;
            cur = next;
            next = tmp;
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < 9; i++) {
            if (MAP[i].length > 0) {
                ans = Math.min(ans, cur[i]);
            }
        }
        return ans;
    }
}