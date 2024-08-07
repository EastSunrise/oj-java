package cn.kingen.oj.leetcode.problem.ch17;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/binode-lcci/">面试题 17.12. BiNode LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STACK, Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_SEARCH_TREE, Tag.LINKED_LIST, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Interview12 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head = new TreeNode(-1);
        TreeNode[] predecessor = new TreeNode[]{head};
        dfs(root, predecessor);
        return head.right;
    }

    private void dfs(TreeNode t, TreeNode[] predecessor) {
        if (t == null) {
            return;
        }
        dfs(t.left, predecessor);
        predecessor[0].right = t;
        t.left = null;
        predecessor[0] = t;
        dfs(t.right, predecessor);
    }
}