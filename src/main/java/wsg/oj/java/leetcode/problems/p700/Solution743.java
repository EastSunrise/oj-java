package wsg.oj.java.leetcode.problems.p700;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 743. Network Delay Time (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/network-delay-time/">Network Delay Time</a>
 * @since 2021-07-27
 */
public class Solution743 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_NN
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        int infinity = Integer.MAX_VALUE >>> 1;
        int[][] graph = new int[n][n];
        for (int[] row : graph) {
            Arrays.fill(row, infinity);
        }
        for (int[] time : times) {
            graph[time[0] - 1][time[1] - 1] = time[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, infinity);
        boolean[] visited = new boolean[n];
        dist[k - 1] = 0;
        for (int i = 0; i < n; i++) {
            // pick the minimum distance vertex from vertices not visited
            int min = infinity, picked = -1;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && dist[v] < min) {
                    min = dist[v];
                    picked = v;
                }
            }
            if (picked == -1) {
                return -1;
            }
            visited[picked] = true;
            // update the distances
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    dist[v] = Math.min(dist[v], dist[picked] + graph[picked][v]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
