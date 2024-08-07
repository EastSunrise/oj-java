package cn.kingen.oj.leetcode.problem.p2400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.List;

import static cn.kingen.oj.leetcode.util.GraphUtils.buildUndirectedGraph;

/**
 * <a href="https://leetcode.cn/problems/minimum-fuel-cost-to-report-to-the-capital/">2477. Minimum Fuel Cost to Report to the Capital</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution145
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.GRAPH},
        difficulty = Difficulty.MEDIUM
)
public class Solution2477 {

    @Complexity(time = "O(n)", space = "O(n)")
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<List<Integer>> graph = buildUndirectedGraph(roads, n);
        long[] res = new long[1];
        dfs(graph, seats, res, -1, 0);
        return res[0];
    }

    /**
     * @return the number of representatives to reach the specific city
     */
    private int dfs(List<List<Integer>> graph, int seats, long[] liter, int p, int u) {
        int personCount = 1;
        for (int v : graph.get(u)) {
            if (v != p) {
                int cnt = dfs(graph, seats, liter, u, v);
                liter[0] += (cnt - 1) / seats + 1;
                personCount += cnt;
            }
        }
        return personCount;
    }
}