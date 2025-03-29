package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/longest-cycle-in-a-graph/">2360. Longest Cycle in a Graph</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1500.Solution1591
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2471
 * @see cn.kingen.oj.leetcode.problem.p2600.Solution2608

 */
@Question(
    tags = {Tag.DEPTH_FIRST_SEARCH, Tag.GRAPH, Tag.TOPOLOGICAL_SORT},
    difficulty = Difficulty.HARD,
    date = "2025-03-29"
)
public class Solution2360 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (edges[i] == -1 || edges[edges[i]] == -1 || visited[i]) {
                continue;
            }
            visited[i] = true;
            int s = edges[i], f = edges[edges[i]];
            while (!visited[s] && s != f && edges[f] != -1 && edges[edges[f]] != -1) {
                visited[s] = true;
                s = edges[s];
                f = edges[edges[f]];
            }
            if (s == f) { // find a cycle
                int length = 1;
                for (int j = edges[s]; j != s; j = edges[j]) {
                    length++;
                }
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }

}