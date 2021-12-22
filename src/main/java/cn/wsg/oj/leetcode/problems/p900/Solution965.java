package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 965. Univalued Binary Tree (EASY)
 *
 * @author Kingen
 * @see Solution1469
 * @see <a href="https://leetcode-cn.com/problems/univalued-binary-tree/">Univalued Binary Tree</a>
 */
public class Solution965 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        return val == root.val && isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }
}
