package cn.wsg.oj.leetcode.problems.p1300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1377. Frog Position After T Seconds (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/frog-position-after-t-seconds/">Frog Position
 * After T Seconds</a>
 */
public class Solution1377 implements Solution {

    public double frogPosition(int n, int[][] edges, int t, int target) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }

        int total = 1;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty() && t >= 0) {
            int size = queue.size();
            boolean found = false;
            for (int i = 0; i < size; i++) {
                int u = queue.remove();
                if (u == target) {
                    found = true;
                }
                visited[u] = true;
                for (int v = 1; v <= n; v++) {
                    if (graph[u][v] && !visited[v]) {
                        queue.offer(v);
                    }
                }
            }
            total *= size;
            if (found && (t == 0 || queue.isEmpty())) {
                return 1D / total;
            }
            t--;
        }
        return 0.0;
    }

    private double dfs(boolean[][] graph, boolean[] visited, int n, int u, int t, int target) {
        if (t < 0) {
            return 0;
        }
        visited[u] = true;
        for (int v = 1; v <= n; v++) {
            if (graph[u][v] && !visited[v]) {

            }
        }
        return 0.0;
    }
}
