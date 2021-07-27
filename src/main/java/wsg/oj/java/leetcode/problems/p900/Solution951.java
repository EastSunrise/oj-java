package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 951. Flip Equivalent Binary Trees (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/flip-equivalent-binary-trees/">Flip Equivalent
 * Binary Trees</a>
 * @since 2021-07-27
 */
public class Solution951 implements Solution {

    /**
     * @complexity T=O(min(n1,n2))
     * @complexity S=O(min(h1,h2))
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }
        if (root2 != null && root1.val == root2.val) {
            if (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) {
                return true;
            }
            return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        }
        return false;
    }
}
