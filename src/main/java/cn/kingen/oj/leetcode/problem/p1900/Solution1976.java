package cn.kingen.oj.leetcode.problem.p1900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

/**
 * <a href="https://leetcode.cn/problems/number-of-ways-to-arrive-at-destination/">1976. Number of Ways to Arrive at Destination</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution797
 * @see cn.kingen.oj.leetcode.problem.p1500.Solution1514
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2045
 */
@Question(
        tags = {Tag.GRAPH, Tag.TOPOLOGICAL_SORT, Tag.DYNAMIC_PROGRAMMING, Tag.SHORTEST_PATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution1976 {

    @Complexity(time = "O(|E|+n^2)", space = "O(n^2)")
    public int countPaths(int n, int[][] roads) {
        int[][] graph = new int[n][n];
        for (int[] road : roads) {
            graph[road[0]][road[1]] = road[2];
            graph[road[1]][road[0]] = road[2];
        }

        // dist[i], count[i]: the minimum distance and its count from 0 to i
        long[] dist = new long[n], counts = new long[n];
        Arrays.fill(dist, -1);

        dist[0] = 0;
        counts[0] = 1;
        boolean[] visited = new boolean[n];
        for (int i = 1; i < n; i++) {
            int min = -1;
            // choose the nearest vertex from reachable but not visited vertices
            for (int v = 0; v < n; v++) {
                if (!visited[v] && dist[v] != -1) {
                    if (min == -1 || dist[v] < dist[min]) {
                        min = v;
                    } else if (dist[v] == dist[min]) {
                        min = v;
                    }
                }
            }
            if (min == -1) {
                break;
            }
            visited[min] = true;
            for (int v = 0; v < n; v++) {
                // update distance and count of v which is not visited but reachable from min
                if (!visited[v] && graph[min][v] > 0) {
                    long dv = dist[min] + graph[min][v];
                    if (dist[v] == -1 || dv < dist[v]) {
                        dist[v] = dv;
                        counts[v] = counts[min];
                    } else if (dv == dist[v]) {
                        counts[v] = (counts[v] + counts[min]) % MOD;
                    }
                }
            }
        }
        return (int) counts[n - 1];
    }
}