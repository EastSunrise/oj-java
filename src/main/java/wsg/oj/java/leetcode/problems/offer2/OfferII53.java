package wsg.oj.java.leetcode.problems.offer2;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 剑指 Offer II 53. 二叉搜索树中的中序后继 (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/P5rCT8/">二叉搜索树中的中序后继</a>
 * @since 2021-08-29
 */
public class OfferII53 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see wsg.oj.java.Complexity#TIME_H
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode mid = root, successor = null;
        while (mid != null) {
            if (mid.val <= p.val) {
                mid = mid.right;
            } else {
                successor = mid;
                mid = mid.left;
            }
        }
        return successor;
    }
}
