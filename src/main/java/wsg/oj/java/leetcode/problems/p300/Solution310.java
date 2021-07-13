package wsg.oj.java.leetcode.problems.p300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution207;
import wsg.oj.java.leetcode.problems.p200.Solution210;

/**
 * todo 310. Minimum Height Trees (Medium)
 *
 * @author Kingen
 * @see Solution207
 * @see Solution210
 * @see <a href="https://leetcode-cn.com/problems/minimum-height-trees/">Minimum Height Trees</a>
 * @since 2021-07-13
 */
public class Solution310 implements Solution {

    /**
     * Finds the longest path and its one or two middle node is the root.
     */
    public int[] findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>(n);
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        // distances[i]: the distance between i and a given key
        int[] distances = new int[n];
        distances[0] = 1;
        // find one side of the longest path
        int left = findFurthest(map, 0, distances);
        Arrays.fill(distances, 0);
        distances[left] = 1;
        // find the other side of the longest path
        int right = findFurthest(map, left, distances);
        Arrays.fill(distances, 0);
        // find the longest path
        List<Integer> longestPath = new ArrayList<>();
        findPath(map, longestPath, left, right, distances);
        int mid = longestPath.size() / 2;
        if ((longestPath.size() & 1) == 0) {
            return new int[]{longestPath.get(mid - 1), longestPath.get(mid)};
        } else {
            return new int[]{longestPath.get(mid)};
        }
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
