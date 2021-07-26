package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 606. Construct String from Binary Tree (EASY)
 *
 * @author Kingen
 * @see Solution536
 * @see Solution652
 * @see <a href="https://leetcode-cn.com/problems/construct-string-from-binary-tree/">Construct
 * String from Binary Tree</a>
 * @since 2021-07-23
 */
public class Solution606 implements Solution {

    /**
     * @see #PREORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public String tree2str(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        tree2str(root, builder);
        return builder.toString();
    }

    private void tree2str(TreeNode node, StringBuilder builder) {
        builder.append(node.val);
        if (node.right != null) {
            builder.append("(");
            if (node.left != null) {
                tree2str(node.left, builder);
            }
            builder.append(")(");
            tree2str(node.right, builder);
            builder.append(")");
        } else if (node.left != null) {
            builder.append("(");
            tree2str(node.left, builder);
            builder.append(")");
        }
    }
}
