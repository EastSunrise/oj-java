package wsg.oj.java.leetcode.problems.p0;

import java.util.Comparator;
import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;
import wsg.oj.java.leetcode.problems.p500.Solution501;

/**
 * 98. Validate Binary Search Tree (Medium)
 *
 * @author Kingen
 * @see Solution94
 * @see Solution501
 * @see <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">Validate Binary
 * Search Tree</a>
 * @since 2021-07-11
 */
public class Solution98 implements Solution {

    /**
     * @see BinaryTree#isBST(Comparator)
     */
    public boolean isValidBST(TreeNode root) {
        return within(root, null, null);
    }

    private boolean within(TreeNode node, Integer min, Integer max) {
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        return (node.left == null || within(node.left, min, node.val))
            && (node.right == null || within(node.right, node.val, max));
    }
}
