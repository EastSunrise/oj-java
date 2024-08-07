package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/beautiful-arrangement/">526. Beautiful Arrangement</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.Solution667
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.BACKTRACKING, Tag.BITMASK},
        difficulty = Difficulty.MEDIUM
)
public class Solution526 {

    @Complexity(time = "O(n*2^n)", space = "O(2^n)")
    public int countArrangement(int n) {
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            graph.get(i).add(i);
            for (int j = 2 * i; j <= n; j += i) {
                graph.get(i).add(j);
                graph.get(j).add(i);
            }
        }
        // memo[state]: the number of permutations that can be formed using the numbers in the state
        int[] memo = new int[1 << n];
        return dfs(graph, memo, n, (1 << n) - 1);
    }

    private int dfs(List<List<Integer>> graph, int[] memo, int i, int state) {
        if (state == 0) { // all numbers are used
            return 1;
        }
        if (memo[state] != 0) {
            return memo[state];
        }
        int cnt = 0;
        for (int j : graph.get(i)) {
            int mask = 1 << (j - 1);
            if ((state & mask) != 0) { // j is not used, set the bit at j-1 to 0 to mark j as used
                cnt += dfs(graph, memo, i - 1, state ^ mask);
            }
        }
        return memo[state] = cnt;
    }
}