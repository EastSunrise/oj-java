package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-number-of-ways-to-reach-the-k-th-stair/">3154. Find Number of Ways to Reach the K-th Stair</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution70
 * @see cn.kingen.oj.leetcode.problem.p700.Solution746
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.MEMOIZATION, Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.COMBINATORICS},
        difficulty = Difficulty.HARD
)
public class Solution3154 {

    @Complexity(time = "O(log{k}*log{k})", space = "O(log{k}*log{k})")
    public int waysToReachStair(int k) {
        return dfs(new HashMap<>(), k, 1, 0, 1);
    }

    private int dfs(Map<Long, Integer> memo, int k, int i, int jump, int canDown) {
        if (i > k + 1) {
            return 0;
        }
        long key = ((long) i << 32) | ((long) jump << 1) | canDown;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int count = i == k ? 1 : 0; // reach k
        if (i > 0 && canDown == 1) { // operation 1
            count += dfs(memo, k, i - 1, jump, 0);
        }
        count += dfs(memo, k, i + (1 << jump), jump + 1, 1);
        memo.put(key, count);
        return count;
    }
}