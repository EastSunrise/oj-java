package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static cn.kingen.oj.leetcode.util.GraphUtils.buildUndirectedGraph;

/**
 * <a href="https://leetcode.cn/problems/count-valid-paths-in-a-tree/">2867. Count Valid Paths in a Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2700.Solution2791
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.NUMBER_THEORY},
        difficulty = Difficulty.HARD
)
public class Solution2867 {

    @Complexity(time = "(n log log n) + n", space = "O(n)")
    public long countPaths(int n, int[][] edges) {
        List<List<Integer>> graph = buildUndirectedGraph(edges, n + 1);

        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, 2, n + 1, true);
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        long ans = 0;
        // memo[x]: size of the largest sub graph that contains x and has no prime number
        int[] memo = new int[n + 1];
        for (int u = 2; u <= n; u++) {
            if (!primes[u]) {
                continue;
            }

            int sum = 0;
            for (int v : graph.get(u)) {
                if (memo[v] == 0) {
                    // all not-prime numbers contained in the sub graph that contains v
                    List<Integer> nps = new ArrayList<>();
                    dfs(graph, primes, nps, u, v);
                    for (Integer np : nps) {
                        memo[np] = nps.size();
                    }
                }

                // paths from nodes of the sub graph that contains v to nodes of other visited sub graphs
                ans += (long) memo[v] * sum;
                sum += memo[v];
            }

            // paths starting from the prime number u
            ans += sum;
        }
        return ans;
    }

    private void dfs(List<List<Integer>> graph, boolean[] primes, List<Integer> nps, int p, int u) {
        if (primes[u]) {
            return;
        }
        nps.add(u);
        for (int v : graph.get(u)) {
            if (v != p) {
                dfs(graph, primes, nps, u, v);
            }
        }
    }
}