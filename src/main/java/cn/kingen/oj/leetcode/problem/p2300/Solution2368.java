package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static cn.kingen.oj.leetcode.util.GraphUtils.buildUndirectedGraph;

/**
 * <a href="https://leetcode.cn/problems/reachable-nodes-with-restrictions/">2368. Reachable Nodes With Restrictions</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution752
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1654
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.UNION_FIND, Tag.GRAPH, Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.MEDIUM
)
public class Solution2368 {

    /**
     * Union-Find.
     */
    @Complexity(time = "O(n*α(n)", space = "O(n)")
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> unavailable = new HashSet<>();
        for (int i : restricted) {
            unavailable.add(i);
        }

        int[] parents = new int[n], heights = new int[n];
        Arrays.setAll(parents, i -> i);
        Arrays.fill(heights, 1);
        for (int[] edge : edges) {
            if (!unavailable.contains(edge[0]) && !unavailable.contains(edge[1])) {
                union(parents, heights, edge[0], edge[1]);
            }
        }

        int ans = 0;
        int r0 = find(parents, 0);
        for (int i = 0; i < n; i++) {
            if (find(parents, i) == r0) {
                ans++;
            }
        }
        return ans;
    }

    int find(int[] parents, int x) {
        if (parents[x] == x) {
            return x;
        }
        int r = find(parents, parents[x]);
        parents[x] = r;
        return r;
    }

    void union(int[] parents, int[] heights, int a, int b) {
        int ap = find(parents, a);
        int bp = find(parents, b);
        if (ap == bp) {
            return;
        }
        if (heights[ap] > heights[bp]) {
            parents[bp] = ap;
        } else if (heights[ap] < heights[bp]) {
            parents[ap] = bp;
        } else {
            parents[ap] = bp;
            heights[bp]++;
        }
    }

    /**
     * Depth-First Search.
     */
    @Complexity(time = "O(n)", space = "O(n)")
    public int reachableNodes_2(int n, int[][] edges, int[] restricted) {
        Set<Integer> unavailable = new HashSet<>();
        for (int i : restricted) {
            unavailable.add(i);
        }
        List<List<Integer>> graph = buildUndirectedGraph(edges, n);
        return dfs(graph, unavailable, -1, 0);
    }

    int dfs(List<List<Integer>> graph, Set<Integer> unavailable, int p, int u) {
        if (unavailable.contains(u)) {
            return 0;
        }
        int cnt = 1;
        for (int v : graph.get(u)) {
            if (v != p) {
                cnt += dfs(graph, unavailable, u, v);
            }
        }
        return cnt;
    }
}