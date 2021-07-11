package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 100. Same Tree (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/same-tree/">Same Tree</a>
 * @since 2021-07-11
 */
class Solution100 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        return q != null && p.val == q.val
            && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
