package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.datastructure.BinaryTree;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p1300.Solution1376;
import cn.wsg.oj.leetcode.problems.p500.Solution559;

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
 */
public class Solution104 implements Solution {

    /**
     * @see BinaryTree#getHeight()
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
