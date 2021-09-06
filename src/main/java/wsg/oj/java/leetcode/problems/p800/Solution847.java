package wsg.oj.java.leetcode.problems.p800;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 847. Shortest Path Visiting All Nodes (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/">Shortest Path
 * Visiting All Nodes</a>
 * @since 2021-07-27
 */
public class Solution847 implements Solution {

    /**
     * @complexity T=O(n^2 * 2^n)
     * @complexity S=O(n * 2^n)
     * @see #BFS
     */
    public int shortestPathLength(int[][] graph) {
        int n = graph.length, m = 1 << n;
        boolean[][] seen = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // current vertex, current state of the whole graph
            queue.offer(new int[]{i, 1 << i});
            // marked as visited
            seen[i][1 << i] = true;
        }

        int target = m - 1, dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pair = queue.remove();
                // extend next vertices
                for (int v : graph[pair[0]]) {
                    int state = pair[1] | (1 << v);
                    if (!seen[v][state]) {
                        if (state == target) {
                            return dist;
                        }
                        queue.offer(new int[]{v, state});
                        seen[v][state] = true;
                    }
                }
            }
            dist++;
        }
        return 0;
    }

    /**
     * Floyd algorithm.
     *
     * @complexity T=O(n^2 * 2^n)
     * @complexity S=O(n * 2^n)
     * @see #DYNAMIC_PROGRAMMING
     */
    public int shortestPathLength2(int[][] graph) {
        int n = graph.length, m = 1 << n, infinity = 0xffffff;
        // dist[i][j]: the shortest distance between i and j
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], infinity);
        }
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                dist[u][v] = 1;
            }
        }

        // Floyd algorithm
        for (int w = 0; w < n; w++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    dist[u][v] = Math.min(dist[u][v], dist[u][w] + dist[w][v]);
                }
            }
        }

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], infinity);
            dp[i][1 << i] = 0;
        }
        for (int state = 1; state < m; state++) {
            for (int u = 0; u < n; u++) {
                if ((state & (1 << u)) != 0) {
                    for (int v = 0; v < n; v++) {
                        if ((state & (1 << v)) != 0 && u != v) {
                            int prevState = state ^ (1 << u);
                            dp[u][state] = Math.min(dp[u][state], dp[v][prevState] + dist[v][u]);
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE, endState = m - 1;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[i][endState]);
        }
        return min;
    }
}
