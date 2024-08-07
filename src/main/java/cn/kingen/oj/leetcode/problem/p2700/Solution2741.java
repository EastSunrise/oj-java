package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

/**
 * <a href="https://leetcode.cn/problems/special-permutations/">2741. Special Permutations</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.BITMASK},
        difficulty = Difficulty.MEDIUM
)
public class Solution2741 {

    @Complexity(time = "O(n^2*2^n)", space = "O(n*2^n)")
    public int specialPerm(int[] nums) {
        int n = nums.length;
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    graph.get(j).add(i);
                    graph.get(i).add(j);
                }
            }
        }

        long cnt = 0;
        int state = (1 << n) - 1;
        // memo[state][i]: the number of special permutations that can be formed
        // using the numbers in the state and nums[i] as the last number
        long[][] memo = new long[1 << n][n];
        for (long[] vs : memo) {
            Arrays.fill(vs, -1);
        }
        for (int p = 0; p < n; p++) { // choose nums[p] as the first number
            cnt += dfs(graph, memo, p, state ^ (1 << p));
        }
        return (int) (cnt % MOD);
    }

    private long dfs(List<List<Integer>> graph, long[][] memo, int i, int state) {
        if (state == 0) { // all numbers are used
            return 1;
        }
        if (memo[state][i] != -1) {
            return memo[state][i];
        }
        long cnt = 0;
        for (int j : graph.get(i)) {
            int mask = 1 << j;
            if ((state & mask) != 0) { // nums[j] is not used, set the bit at j-1 to 0 to mark nums[j] as used
                cnt += dfs(graph, memo, j, state ^ mask);
            }
        }
        return memo[state][i] = cnt;
    }
}