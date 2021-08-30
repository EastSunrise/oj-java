package wsg.oj.java.leetcode.problems.offer;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点  LCOF (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/">二叉搜索树的第k大节点
 * LCOF</a>
 * @since 2021-07-28
 */
public class Offer54 implements Solution {

    /**
     * @see #INORDER
     */
    public int kthLargest(TreeNode root, int k) {
        return count(root, new int[]{k});
    }

    private int count(TreeNode cur, int[] k) {
        if (cur == null) {
            return -1;
        }
        int val = count(cur.right, k);
        if (k[0] == 0) {
            // found in the right subtree
            return val;
        }
        if (k[0] == 1) {
            val = cur.val;
            k[0]--;
            // this node is the target
            return val;
        }
        k[0]--;
        // find the target in the left subtree
        return count(cur.left, k);
    }
}
