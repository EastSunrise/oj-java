package wsg.oj.java.graph;

import java.util.Arrays;

/**
 * Dijkstra's Algorithm.
 *
 * @author Kingen
 * @see <a href="https://eastsunrise.github.io/wiki-kingen/cs/algorithms/graph/dijkstra%27s-algorithm.html">Dijkstra's
 * Algorithm</a>
 * @since 2021/8/7
 */
public class Dijkstra {

    /**
     * @param graph a weighted directed graph, graph[u][v] means the weight (positive) from vertex u
     *              to v, or {@code 0} if there is no edge between the two vertices
     * @param n     the number of vertices
     * @param s     the source vertex, 0&ge;s&gt;n
     * @return the minimal distance between each vertex and the source vertex, or {@code -1} if not
     * reachable
     */
    public static int[] minDistance(int[][] graph, int n, int s) {
        // dist[v]: the distance from s to v
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, -1);

        dist[s] = 0;
        for (int i = 1; i < n; i++) {
            int min = -1;
            for (int v = 0; v < n; v++) {
                // choose the nearest one from reachable and not visited vertices
                if (!visited[v] && dist[v] != -1 && (min == -1 || dist[v] < dist[min])) {
                    min = v;
                }
            }
            if (min == -1) {
                return dist;
            }
            visited[min] = true;
            for (int v = 0; v < n; v++) {
                // vertex v is reachable
                if (!visited[v] && graph[min][v] > 0) {
                    if (dist[v] == -1 || dist[min] + graph[min][v] < dist[v]) {
                        // a shorter path: s → min → v
                        dist[v] = dist[min] + graph[min][v];
                    }
                }
            }
        }
        return dist;
    }
}
