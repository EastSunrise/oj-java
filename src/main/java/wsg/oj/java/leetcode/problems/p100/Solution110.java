package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 110. Balanced Binary Tree (Easy)
 *
 * @author Kingen
 * @see Solution104
 * @see <a href="https://leetcode-cn.com/problems/balanced-binary-tree/">Balanced Binary Tree</a>
 * @since 2021-07-11
 */
public class Solution110 implements Solution {

    /**
     * @see #POSTORDER
     */
    public boolean isBalanced(TreeNode root) {
        return balancedAndHeight(root) >= 0;
    }

    /**
     * @return the height of the node, or -1 if the node is not balanced
     */
    private int balancedAndHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = balancedAndHeight(node.left);
        if (left < 0) {
            // not balanced subtree
            return -1;
        }
        int right = balancedAndHeight(node.right);
        if (right < 0) {
            // not balanced subtree
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            // not balanced
            return -1;
        }
        return Math.max(left, right) + 1;
    }

}
