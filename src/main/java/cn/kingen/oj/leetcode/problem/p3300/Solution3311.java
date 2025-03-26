package cn.kingen.oj.leetcode.problem.p3300;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/construct-2d-grid-matching-graph-layout/">3311. Construct 2D Grid Matching Graph Layout</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.GRAPH, Tag.ARRAY, Tag.HASH_TABLE, Tag.MATRIX},
        difficulty = Difficulty.HARD
)
public class Solution3311 {

    public int[][] constructGridLayout(int n, int[][] edges) {
        int e = edges.length;
        double x = (double) (2 * n - e) / 2;
        int a = (int) (x - Math.sqrt(x * x - n)), b = n / a; // grid[a][b]

        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int vertexDegree = a == 1 ? 1 : 2;
        int edgeDegree = a == 1 ? 2 : 3;
        int s = -1;
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == vertexDegree) {
                s = i;
                break;
            }
        }

        boolean[] visited = new boolean[n];
        List<Integer> row0 = new ArrayList<>();
        row0.add(s);
        visited[s] = true;
        if (a == 2) { // grid[2][b]
            int u = findNext(graph, visited, s, vertexDegree);
            row0.add(u);
            visited[u] = true;
        } else if (a > 2) {
            do {
                s = findNext(graph, visited, s, edgeDegree);
                row0.add(s);
                visited[s] = true;
            } while (graph[s].size() != vertexDegree); // last one of the row
        }

        if (row0.size() != b) {
            a = b;
            b = n / a;
        }

        int[][] grid = new int[a][b];
        for (int i = 0; i < b; i++) {
            grid[0][i] = row0.get(i);
        }
        for (int i = 1; i < a; i++) {
            for (int j = 0; j < b; j++) {
                for (int u : graph[grid[i - 1][j]]) {
                    if (!visited[u]) {
                        grid[i][j] = u;
                        visited[u] = true;
                        break;
                    }
                }
            }
        }
        return grid;
    }

    private int findNext(List<Integer>[] graph, boolean[] visited, int u, int degree) {
        for (int v : graph[u]) {
            if (!visited[v] && graph[v].size() <= degree) {
                return v;
            }
        }
        return -1;
    }
}