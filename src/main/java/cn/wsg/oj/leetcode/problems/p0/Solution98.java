package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.datastructure.BinaryTree;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p500.Solution501;
import java.util.Comparator;

/**
 * 98. Validate Binary Search Tree (Medium)
 *
 * @author Kingen
 * @see Solution94
 * @see Solution501
 * @see <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">Validate Binary
 * Search Tree</a>
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
