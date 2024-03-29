package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 剑指 Offer 26. 树的子结构  LCOF (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/">树的子结构  LCOF</a>
 */
public class Offer26 implements Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return startsWith(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean startsWith(TreeNode node, TreeNode prefix) {
        if (prefix == null) {
            return true;
        }
        if (node == null) {
            return false;
        }
        return node.val == prefix.val
            && startsWith(node.left, prefix.left) && startsWith(node.right, prefix.right);
    }
}
