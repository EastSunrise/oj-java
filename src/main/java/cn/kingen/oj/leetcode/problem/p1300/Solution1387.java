package cn.kingen.oj.leetcode.problem.p1300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/sort-integers-by-the-power-value/">1387. Sort Integers by The Power Value</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2593

 */
@Question(
    tags = {Tag.MEMOIZATION, Tag.DYNAMIC_PROGRAMMING, Tag.SORTING},
    difficulty = Difficulty.MEDIUM
)
public class Solution1387 {

    @Complexity(time = "O(#)", space = "O(n)")
    public int getKth(int lo, int hi, int k) {
        int n = hi - lo + 1;
        int[][] weights = new int[n][2];
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            weights[i][0] = lo + i;
            weights[i][1] = dfs(memo, lo + i);
        }

        Arrays.sort(weights, (a1, a2) -> a1[1] == a2[1] ? a1[0] - a2[0] : a1[1] - a2[1]);
        return weights[k - 1][0];
    }

    private int dfs(Map<Integer, Integer> memo, int x) {
        if (x == 1) {
            return 0;
        }
        if (memo.containsKey(x)) {
            return memo.get(x);
        }
        int w = (x & 1) == 0 ? dfs(memo, x >> 1) : dfs(memo, 3 * x + 1);
        memo.put(x, w + 1);
        return w + 1;
    }
}