package cn.wsg.oj.leetcode.problems.offer;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列 LCOF (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/">二叉搜索树的后序遍历序列
 * LCOF</a>
 */
public class Offer33 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        int p = n, max = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > max) {
                return false;
            }
            while (p != n && postorder[i] < postorder[p]) {
                max = postorder[p++];
            }
            postorder[--p] = postorder[i];
        }
        return true;
    }

    /**
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_H
     */
    public boolean verifyPostorder2(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int fromIn, int toIn) {
        if (toIn <= fromIn) {
            return true;
        }
        int i = fromIn, root = postorder[toIn];
        // find the dividing line of the left and right subtrees
        while (i < toIn && postorder[i] < root) {
            i++;
        }
        if (!verifyPostorder(postorder, fromIn, i - 1)
            || !verifyPostorder(postorder, i, toIn - 1)) {
            return false;
        }
        while (++i < toIn) {
            if (postorder[i] < root) {
                return false;
            }
        }
        return true;
    }
}
