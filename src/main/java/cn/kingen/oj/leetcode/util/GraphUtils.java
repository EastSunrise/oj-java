package cn.kingen.oj.leetcode.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kingen
 **/
public final class GraphUtils {

    /**
     * Builds an undirected graph by adjacency list.
     *
     * @param edges the edges of the graph
     * @param n     the number of vertices
     */
    public static List<List<Integer>> buildUndirectedGraph(int[][] edges, int n) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    /**
     * Builds a weighted undirected graph by adjacency list.
     *
     * @param edges the edges of the graph
     * @param n     the number of vertices
     */
    public static List<List<int[]>> buildWeightedGraph(int[][] edges, int n) {
        List<List<int[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }
        return graph;
    }
}
