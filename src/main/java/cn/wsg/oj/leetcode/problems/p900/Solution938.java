package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 938. Range Sum of BST (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/range-sum-of-bst/">Range Sum of BST</a>
 */
public class Solution938 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
