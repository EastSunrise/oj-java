package cn.kingen.oj.leetcode.problem.p1200;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree/">1261. Find Elements in a Contaminated Binary Tree</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.DESIGN, Tag.HASH_TABLE, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class FindElements {

    private final boolean[] nodes;

    @Complexity(time = "O(n)", space = "O(n)")
    FindElements(TreeNode root) {
        int height = getHeight(root);
        this.nodes = new boolean[2 << height];
        dfs(root, 0);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private void dfs(TreeNode node, int val) {
        nodes[val] = true;
        if (node.left != null) {
            dfs(node.left, (val << 1) + 1);
        }
        if (node.right != null) {
            dfs(node.right, (val + 1) << 1);
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    boolean find(int target) {
        return target >= 0 && target < nodes.length && nodes[target];
    }
}