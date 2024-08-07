package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/design-graph-with-shortest-path-calculator/">2642. Design Graph With Shortest Path Calculator</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1786
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2277
 */
@Question(
        tags = {Tag.GRAPH, Tag.DESIGN, Tag.SHORTEST_PATH, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.HARD
)
public class Graph {

    private final int n;
    private final int[][] graph;

    public Graph(int n, int[][] edges) {
        this.n = n;
        this.graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    public void addEdge(int[] edge) {
        graph[edge[0]][edge[1]] = edge[2];
    }

    @Complexity(time = "O(n^2)", space = "O(n)")
    public int shortestPath(int s, int t) {
        // dist[u]: the distance from s to u
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        dist[s] = 0;
        boolean[] visited = new boolean[n];
        while (true) {
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] != -1 && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            if (u == -1) {
                return -1;
            }
            if (u == t) {
                return dist[u];
            }

            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] > 0 && (dist[v] == -1 || dist[u] + graph[u][v] < dist[v])) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
    }
}