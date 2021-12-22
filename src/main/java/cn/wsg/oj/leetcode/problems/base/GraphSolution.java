package cn.wsg.oj.leetcode.problems.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Common methods of graph operations.
 *
 * @author Kingen
 */
public interface GraphSolution extends Solution {

    default Map<Integer, List<Integer>> mapToUndirectedEdges(int[][] pairs) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int[] pair : pairs) {
            edges.computeIfAbsent(pair[0], key -> new ArrayList<>()).add(pair[1]);
            edges.computeIfAbsent(pair[1], key -> new ArrayList<>()).add(pair[0]);
        }
        return edges;
    }

    default Map<Integer, List<Integer>> mapToDirectedEdges(int[][] pairs) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int[] pair : pairs) {
            edges.computeIfAbsent(pair[0], key -> new ArrayList<>()).add(pair[1]);
        }
        return edges;
    }
}
