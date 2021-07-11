package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 103. Binary Tree Zigzag Level Order Traversal (Medium)
 *
 * @author Kingen
 * @see Solution102
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/">Binary
 * Tree Zigzag Level Order Traversal</a>
 * @since 2021-07-11
 */
class Solution103 extends BinaryTree implements Solution {

    /**
     * @see #traverseLevels(TreeNode, Consumer)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] inverted = new boolean[1];
        traverseLevels(root, level -> {
            if (inverted[0]) {
                Collections.reverse(level);
            }
            res.add(level);
            inverted[0] = !inverted[0];
        });
        return res;
    }
}
