package wsg.oj.java.leetcode.problems.p100;

import java.util.Collections;
import java.util.List;
import wsg.oj.java.datastructure.TreeNode;

/**
 * 107. Binary Tree Level Order Traversal II (Medium)
 *
 * @author Kingen
 * @see Solution102
 * @see Solution637
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/">Binary Tree
 * Level Order Traversal II</a>
 * @since 2021-07-08
 */
class Solution107 extends Solution102 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = levelOrder(root);
        Collections.reverse(res);
        return res;
    }
}
