package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 104. Maximum Depth of Binary Tree (Easy)
 *
 * @author Kingen
 * @see Solution110
 * @see Solution111
 * @see Solution559
 * @see Solution1376
 * @see <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">Maximum Depth of
 * Binary Tree</a>
 * @since 2021-07-11
 */
class Solution104 extends BinaryTree implements Solution {

    /**
     * @see #getHeight(TreeNode)
     */
    public int maxDepth(TreeNode root) {
        return getHeight(root);
    }
}
