package cn.kingen.oj.leetcode.problem.p1400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/kth-ancestor-of-a-tree-node/">1483. Kth Ancestor of a Tree Node</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2800.Solution2846
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.DESIGN, Tag.BINARY_SEARCH, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class TreeAncestor {

    private static final int C = 16;

    // fa[x][i] = 节点 x 的第 2^i 个祖先节点
    private final int[][] fa;

    @Complexity(time = "O(C*n)", space = "O(C*n)")
    TreeAncestor(int n, int[] parent) {
        this.fa = new int[n][C];
        for (int x = 0; x < n; x++) {
            fa[x][0] = parent[x];
        }
        for (int i = 1; i < C; i++) {
            for (int x = 0; x < n; x++) {
                if (fa[x][i - 1] == -1) {
                    fa[x][i] = -1;
                } else {
                    fa[x][i] = fa[fa[x][i - 1]][i - 1];
                }
            }
        }
    }

    @Complexity(time = "O(C)", space = "O(1)")
    int getKthAncestor(int node, int k) {
        int i = 0;
        while (k > 0) {
            if ((k & 1) == 1) {
                node = fa[node][i];
                if (node == -1) {
                    return -1;
                }
            }
            i++;
            k >>= 1;
        }
        return node;
    }
}