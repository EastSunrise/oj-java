package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree (Easy)
 *
 * @author Kingen
 * @see Solution236
 * @see Solution1257
 * @see Solution1644
 * @see Solution1650
 * @see Solution1676
 * @see <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">Lowest
 * Common Ancestor of a Binary Search Tree</a>
 */
public class Solution235 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see Complexity#TIME_H
     * @see Complexity#SPACE_CONSTANT
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < min) {
                cur = cur.right;
            } else if (cur.val > max) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        throw new IllegalArgumentException("Not found");
    }
}
