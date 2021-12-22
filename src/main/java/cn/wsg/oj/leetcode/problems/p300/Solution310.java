package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution207;
import cn.wsg.oj.leetcode.problems.p200.Solution210;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * todo 310. Minimum Height Trees (Medium)
 *
 * @author Kingen
 * @see Solution207
 * @see Solution210
 * @see <a href="https://leetcode-cn.com/problems/minimum-height-trees/">Minimum Height Trees</a>
 */
public class Solution310 implements Solution {

    List<Integer> part1 = new ArrayList<>();
    List<Integer> part2 = new ArrayList<>();

    /**
     * The subtree formed after removing all leaves nodes of the source tree has the same root
     * labels of minimum height trees with the source tree.
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }

        Map<Integer, List<Integer>> graph = new HashMap<>(n);
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        while (graph.size() > 2) {
            List<Integer> leaves = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
                if (entry.getValue().size() == 1) {
                    leaves.add(entry.getKey());
                }
            }
            for (int leaf : leaves) {
                graph.get(graph.remove(leaf).get(0)).remove(Integer.valueOf(leaf));
            }
        }
        return new ArrayList<>(graph.keySet());
    }

    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>(n);
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        findLongestPath(graph, new boolean[n], 0);
        int len = part1.size() + part2.size();
        return part1.subList((len - 1) / 2, len / 2 + 1);
    }

    private List<Integer> findLongestPath(Map<Integer, List<Integer>> graph, boolean[] visited,
        int root) {
        visited[root] = true;
        // find the two longest path starting with the root node
        List<Integer> longest = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for (int p : graph.get(root)) {
            if (!visited[p]) {
                List<Integer> path = findLongestPath(graph, visited, p);
                if (path.size() > longest.size()) {
                    second = longest;
                    longest = path;
                } else if (path.size() > second.size()) {
                    second = path;
                }
            }
        }
        // calculate the longest path going through the root node
        longest.add(root);
        if (longest.size() + second.size() > part1.size() + part2.size()) {
            part1 = new ArrayList<>(longest);
            part2 = new ArrayList<>(second);
        }
        return longest;
    }

    private int findFurthest(Map<Integer, List<Integer>> edges, int target, int[] distances) {
        int furthest = target;
        for (int vertex : edges.get(target)) {
            if (distances[vertex] == 0) {
                distances[vertex] = distances[target] + 1;
                int res = findFurthest(edges, vertex, distances);
                if (distances[res] > distances[furthest]) {
                    furthest = res;
                }
            }
        }
        return furthest;
    }

    private boolean findPath(Map<Integer, List<Integer>> edges, List<Integer> path, int cur,
        int target, int[] visited) {
        if (visited[cur] == 1) {
            return false;
        }
        if (cur == target) {
            path.add(cur);
            return true;
        }
        visited[cur] = 1;
        path.add(cur);
        for (int vertex : edges.get(cur)) {
            if (findPath(edges, path, vertex, target, visited)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
}
