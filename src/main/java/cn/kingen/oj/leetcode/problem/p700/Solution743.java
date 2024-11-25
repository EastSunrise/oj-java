package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/network-delay-time/">743. Network Delay Time</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2039
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2045
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.GRAPH, Tag.SHORTEST_PATH, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution743 {

    @Complexity(time = "O(n^2+|E|)", space = "O(|E|)")
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(time);
        }

        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        int count = 0, ans = 0;
        for (; ; ) {
            int min = Integer.MAX_VALUE, picked = -1;
            for (int i = 1; i <= n; i++) { // pick the unvisited node with the smallest distance
                if (!visited[i] && dist[i] < min) {
                    min = dist[i];
                    picked = i;
                }
            }
            if (picked == -1) {
                return count == n ? ans : -1;
            }

            visited[picked] = true;
            count++;
            ans = min;
            for (int[] time : graph.get(picked)) { // update the distance of the adjacent nodes
                int v = time[1];
                dist[v] = Math.min(dist[v], dist[picked] + time[2]);
            }
        }
    }
}