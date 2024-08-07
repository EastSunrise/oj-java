package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-edge-weight-equilibrium-queries-in-a-tree/">2846. Minimum Edge Weight Equilibrium Queries in a Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1400.TreeAncestor
 */
@Question(
        tags = {Tag.TREE, Tag.GRAPH, Tag.ARRAY, Tag.STRONGLY_CONNECTED_COMPONENT},
        difficulty = Difficulty.HARD
)
public class Solution2846 {

    @Complexity(time = "(n+q)Wlogn", space = "O(nWlogn)")
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        List<List<int[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        // depth[u]: the depth of node u in the tree with 0 as root (the depth of root is 0)
        int[] depth = new int[n];
        int h = 32 - Integer.numberOfLeadingZeros(n);
        // jump[u][i]: the node that node u reaches after 2^i steps upwards
        int[][] jump = new int[n][h];
        Arrays.stream(jump).forEach(ps -> Arrays.fill(ps, -1));
        // count[u][i][w]: the count of weight w between node u and jump[u][j]
        int[][][] count = new int[n][h][27];
        dfs(graph, depth, jump, count, -1, 0);

        for (int i = 1; i < h; i++) {
            for (int u = 0; u < n; u++) {
                int p = jump[u][i - 1];
                if (p != -1) {
                    jump[u][i] = jump[p][i - 1];
                    for (int w = 1; w < 27; w++) {
                        count[u][i][w] += count[u][i - 1][w] + count[p][i - 1][w];
                    }
                }
            }
        }

        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int u = queries[q][0], v = queries[q][1];
            if (depth[u] > depth[v]) {
                int tmp = u;
                u = v;
                v = tmp;
            }

            int pathLen = depth[u] + depth[v];
            int[] cw = new int[27];
            for (int d = depth[v] - depth[u]; d > 0; d &= d - 1) {
                // jump 2^i steps upwards from v
                int i = Integer.numberOfTrailingZeros(d);
                for (int w = 1; w < 27; w++) {
                    cw[w] += count[v][i][w];
                }
                v = jump[v][i];
            }

            int lca;
            if (u != v) {
                for (int i = h - 1; i >= 0; i--) {
                    int pu = jump[u][i], pv = jump[v][i];
                    if (pu != pv) {
                        for (int w = 1; w < 27; w++) {
                            cw[w] += count[u][i][w] + count[v][i][w];
                        }
                        u = pu;
                        v = pv;
                    }
                }
                for (int w = 1; w < 27; w++) {
                    cw[w] += count[u][0][w] + count[v][0][w];
                }
                lca = jump[u][0];
            } else {
                lca = u;
            }

            int maxCnt = 0;
            for (int c : cw) {
                maxCnt = Math.max(maxCnt, c);
            }
            ans[q] = pathLen - depth[lca] * 2 - maxCnt;
        }
        return ans;
    }

    private void dfs(List<List<int[]>> graph, int[] depth, int[][] jump, int[][][] count, int p, int u) {
        jump[u][0] = p;
        for (int[] edge : graph.get(u)) {
            int v = edge[0];
            if (v != p) {
                depth[v] = depth[u] + 1;
                count[v][0][edge[1]] = 1;
                dfs(graph, depth, jump, count, u, v);
            }
        }
    }
}