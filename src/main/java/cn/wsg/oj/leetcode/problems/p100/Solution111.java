package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree (Easy)
 *
 * @author Kingen
 * @see Solution102
 * @see Solution104
 * @see <a href="https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/">Minimum Depth of
 * Binary Tree</a>
 */
public class Solution111 implements Solution {

    /**
     * @see #POSTORDER
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
