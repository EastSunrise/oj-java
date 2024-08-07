package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/minimize-malware-spread-ii/">928. Minimize Malware Spread II</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.UNION_FIND, Tag.GRAPH, Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.HARD
)
public class Solution928 {

    @Complexity(time = "O(n^2)", space = "O(n^2)")
    public int minMalwareSpreadII(int[][] graph, int[] initial) {
        int n = graph.length, m = initial.length;
        boolean[] infected = new boolean[n];
        for (int u : initial) {
            infected[u] = true;
        }

        int[] parents = new int[n];
        int[] sizes = new int[n];
        Arrays.fill(parents, -1);
        for (int p = 0; p < n; p++) {
            if (parents[p] != -1 || infected[p]) {
                continue;
            }
            sizes[p] = dfs(graph, infected, parents, p, p);
        }

        List<Set<Integer>> inflect = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            inflect.add(new HashSet<>());
        }
        int[] inflectedByCount = new int[n];
        for (int i = 0; i < m; i++) {
            int u = initial[i];
            for (int v = 0; v < n; v++) {
                if (!infected[v] && graph[u][v] == 1) {
                    inflect.get(i).add(parents[v]);
                }
            }
            for (Integer p : inflect.get(i)) {
                inflectedByCount[p]++;
            }
        }

        int ans = -1, max = -1;
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (Integer p : inflect.get(i)) {
                if (inflectedByCount[p] == 1) {
                    count += sizes[p];
                }
            }
            int u = initial[i];
            if (count > max || (count == max && u < ans)) {
                max = count;
                ans = u;
            }
        }
        return ans;
    }

    /**
     * Finds the size of the uninfected connected component of the node {@code p} in the graph {@code graph}.
     */
    private int dfs(int[][] graph, boolean[] infected, int[] parents, int p, int i) {
        parents[i] = p;
        int size = 1;
        for (int j = p + 1; j < graph.length; j++) {
            if (graph[i][j] == 1 && !infected[j] && parents[j] == -1) {
                size += dfs(graph, infected, parents, p, j);
            }
        }
        return size;
    }
}