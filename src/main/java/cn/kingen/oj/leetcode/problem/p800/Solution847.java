package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/shortest-path-visiting-all-nodes/">847. Shortest Path Visiting All Nodes</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p3100.Solution3149
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.BREADTH_FIRST_SEARCH, Tag.GRAPH, Tag.DYNAMIC_PROGRAMMING, Tag.BITMASK},
        difficulty = Difficulty.HARD
)
public class Solution847 {

    @Complexity(time = "O(n^2*2^n)", space = "O(n*2^n)")
    private int shortestPathLength(int[][] graph) {
        int n = graph.length, mask = (1 << n) - 1;
        Queue<int[]> paths = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][mask + 1];
        for (int u = 0; u < n; u++) {
            int state = 1 << u;
            paths.offer(new int[]{u, state});
            visited[u][state] = true;
        }
        for (int dist = 0; ; dist++) {
            int size = paths.size();
            for (int i = 0; i < size; i++) { // check all paths with a length of 'dist'
                int[] path = paths.remove();
                int state = path[1];
                if (state == mask) { // the path has covered all nodes
                    return dist;
                }

                for (int v : graph[path[0]]) {
                    int nextState = state | (1 << v);
                    if (!visited[v][nextState]) { // avoid duplicate
                        paths.offer(new int[]{v, nextState});
                        visited[v][nextState] = true;
                    }
                }
            }
        }
    }
}