package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static cn.kingen.oj.leetcode.util.GraphUtils.buildWeightedGraph;

/**
 * <a href="https://leetcode.cn/problems/minimum-time-to-visit-disappearing-nodes/">3112. Minimum Time to Visit Disappearing Nodes</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GRAPH, Tag.ARRAY, Tag.SHORTEST_PATH, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution3112 {

    @Complexity(time = "n+m*log{m}", space = "m+n")
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<int[]>> graph = buildWeightedGraph(edges, n);
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0});
        dist[0] = 0;
        boolean[] visited = new boolean[n];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[1];
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            for (int[] edge : graph.get(u)) {
                int v = edge[0], w = edge[1];
                if (visited[v]) {
                    continue;
                }
                int d = dist[u] + w;
                if (d < disappear[v] && (dist[v] == -1 || dist[v] > d)) {
                    dist[v] = d;
                    pq.offer(new int[]{d, v});
                }
            }
        }
        return dist;
    }
}