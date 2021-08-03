package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 623. Add One Row to Tree (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/add-one-row-to-tree/">Add One Row to Tree</a>
 * @since 2021-07-23
 */
public class Solution623 implements Solution {

    /**
     * @complexity T=O(2^d)
     * @complexity S=O(d)
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        addRow(root, val, 2, depth);
        return root;
    }

    private void addRow(TreeNode node, int val, int d, int depth) {
        if (node != null) {
            if (d == depth) {
                node.left = new TreeNode(val, node.left, null);
                node.right = new TreeNode(val, null, node.right);
            } else {
                addRow(node.left, val, d + 1, depth);
                addRow(node.right, val, d + 1, depth);
            }
        }
    }
}
