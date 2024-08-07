package cn.kingen.oj.leetcode.problem.p2100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * <a href="https://leetcode.cn/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/">2192. All Ancestors of a Node in a Directed Acyclic Graph</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1700.Solution1786
 */
@Question(
        tags = {Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.GRAPH, Tag.TOPOLOGICAL_SORT},
        difficulty = Difficulty.MEDIUM
)
public class Solution2192 {

    @Complexity(time = "O(|V|+|E|)", space = "O(|V|+|E|)", note = "|V| is the number of nodes, |E| is the number of edges")
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
        }
        List<Set<Integer>> memo = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            memo.add(null);
        }
        for (int i = 0; i < n; i++) {
            dfs(memo, graph, i);
        }
        return memo.stream().map(Set::stream).map(s -> s.sorted().toList()).toList();
    }

    private Set<Integer> dfs(List<Set<Integer>> memo, List<List<Integer>> graph, int u) {
        if (memo.get(u) == null) {
            memo.set(u, new HashSet<>());
            for (int v : graph.get(u)) {
                memo.get(u).addAll(dfs(memo, graph, v));
                memo.get(u).add(v);
            }
        }
        return memo.get(u);
    }
}