package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimize-malware-spread/">924. Minimize Malware Spread</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.UNION_FIND, Tag.GRAPH, Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.HARD
)
public class Solution924 {

    @Complexity(time = "O(n^2)", space = "O(n)")
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        int[] parents = new int[n];
        int[] sizes = new int[n];
        Arrays.fill(parents, -1);
        for (int i = 0; i < n; i++) {
            if (parents[i] != -1) {
                continue;
            }
            sizes[i] = dfs(graph, parents, i, i);
        }

        int[] infectedCount = new int[n];
        for (int i : initial) {
            infectedCount[parents[i]]++;
        }
        int ans = n, count = 0;
        for (int i : initial) {
            int p = parents[i];
            if (infectedCount[p] > 1) {
                if (count == 0 && i < ans) {
                    ans = i;
                }
            } else if (sizes[p] > count) {
                ans = i;
                count = sizes[p];
            } else if (sizes[p] == count && i < ans) {
                ans = i;
            }
        }
        return ans;
    }

    private int dfs(int[][] graph, int[] parents, int p, int i) {
        parents[i] = p;
        int size = 1;
        for (int j = p + 1; j < graph.length; j++) {
            if (graph[i][j] == 1 && parents[j] == -1) {
                size += dfs(graph, parents, p, j);
            }
        }
        return size;
    }
}