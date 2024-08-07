package cn.kingen.oj.leetcode.problem.p1700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.*;

import static cn.kingen.oj.leetcode.util.GraphUtils.buildUndirectedGraph;
import static cn.kingen.oj.leetcode.util.MathUtils.gcd;

/**
 * <a href="https://leetcode.cn/problems/tree-of-coprimes/">1766. Tree of Coprimes</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.ARRAY, Tag.MATH, Tag.NUMBER_THEORY},
        difficulty = Difficulty.HARD
)
public class Solution1766 {

    private static final int C = 51;
    private static final List<Set<Integer>> coprimes = new ArrayList<>(C);

    static {
        for (int i = 0; i < C; i++) {
            coprimes.add(new HashSet<>());
        }
        for (int i = 1; i < C; i++) {
            for (int j = 1; j < C; j++) {
                if (gcd(i, j) == 1) {
                    coprimes.get(i).add(j);
                    coprimes.get(j).add(i);
                }
            }
        }
    }

    @Complexity(time = "O(C*n)", space = "C+n")
    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> graph = buildUndirectedGraph(edges, n);
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        List<List<Integer>> pathNode = new ArrayList<>(C), pathDepth = new ArrayList<>(C);
        for (int i = 0; i < C; i++) {
            pathNode.add(new ArrayList<>());
            pathDepth.add(new ArrayList<>());
        }
        dfs(ans, nums, graph, pathNode, pathDepth, 0, -1, 0);
        return ans;
    }

    /**
     * @param pathDepth pathDepth[x] is the list of depths of nodes whose values are x
     * @param pathNode  pathNode[x] is the list of nodes whose values are x
     * @param depth     depth of current node
     */
    private void dfs(int[] ans, int[] nums, List<List<Integer>> graph, List<List<Integer>> pathNode, List<List<Integer>> pathDepth, int depth, int p, int u) {
        // get the last node in path coprime to nums[u]
        int x = nums[u], last = -1;
        for (int y : coprimes.get(x)) {
            List<Integer> depths = pathDepth.get(y);
            if (!depths.isEmpty() && (depths.getLast()) > last) {
                last = depths.getLast();
                ans[u] = pathNode.get(y).getLast();
            }
        }

        // add current node to path
        pathNode.get(x).add(u);
        pathDepth.get(x).add(depth);
        for (int v : graph.get(u)) {
            if (v == p) {
                continue;
            }
            dfs(ans, nums, graph, pathNode, pathDepth, depth + 1, u, v);
        }
        pathNode.get(x).removeLast();
        pathDepth.get(x).removeLast();
    }
}