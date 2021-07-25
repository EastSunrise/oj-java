package wsg.oj.java.leetcode.problems.old;

import wsg.oj.java.datastructure.TreeNode;

/**
 * @author Kingen
 */
public class TreeSolution {

    // 951. 翻转等价二叉树
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 != null) {
            if (root2 != null) {
                if (root1.val == root2.val) {
                    return
                        (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                            || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right,
                            root2.left));
                }
            }
        }
        return false;
    }
}
