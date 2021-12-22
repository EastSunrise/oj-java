package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 606. Construct String from Binary Tree (EASY)
 *
 * @author Kingen
 * @see Solution536
 * @see Solution652
 * @see <a href="https://leetcode-cn.com/problems/construct-string-from-binary-tree/">Construct
 * String from Binary Tree</a>
 */
public class Solution606 implements Solution {

    /**
     * @see #PREORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
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
