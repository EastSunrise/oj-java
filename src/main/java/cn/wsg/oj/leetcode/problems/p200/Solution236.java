package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree (Medium)
 *
 * @author Kingen
 * @see Solution235
 * @see Solution1257
 * @see Solution1644
 * @see Solution1650
 * @see Solution1676
 * @see <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/">Lowest
 * Common Ancestor of a Binary Tree</a>
 */
public class Solution236 implements Solution {

    /**
     * @return {@literal null} if the node is null, p or q if this node is the ancestor of p or q,
     * this node if this node is the ancestor of both p and q
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            // find p or q
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            // both p and q are the descendants of this node
            return root;
        }
        return left != null ? left : right;
    }
}
