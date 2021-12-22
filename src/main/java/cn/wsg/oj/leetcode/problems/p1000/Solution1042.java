package cn.wsg.oj.leetcode.problems.p1000;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1042. Flower Planting With No Adjacent (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/flower-planting-with-no-adjacent/">Flower Planting
 * With No Adjacent</a>
 */
public class Solution1042 implements Solution {

    /**
     * @complexity T=O(|E|+4*n)
     * @complexity S=O(4*n)
     */
    public int[] gardenNoAdj(int n, int[][] paths) {
        // graph[i][0]: the number of adjacent gardens of garden i
        int[][] graph = new int[n][4];
        for (int[] path : paths) {
            int u = path[0] - 1, v = path[1] - 1;
            graph[u][++graph[u][0]] = v;
            graph[v][++graph[v][0]] = u;
        }
        int[] planted = new int[n];
        for (int u = 0; u < n; u++) {
            boolean[] flowers = new boolean[5];
            for (int i = 1; i <= graph[u][0]; i++) {
                int v = graph[u][i];
                flowers[planted[v]] = true;
            }
            int flower = 0;
            for (int i = 1; i <= 4; i++) {
                if (!flowers[i]) {
                    flower = i;
                    break;
                }
            }
            planted[u] = flower;
        }
        return planted;
    }
}
