package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 814. Binary Tree Pruning (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-pruning/">Binary Tree Pruning</a>
 */
public class Solution814 implements Solution {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root.left == null && root.right == null && root.val == 0 ? null : root;
    }
}
