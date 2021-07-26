package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
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
public class Solution103 extends BinaryTree implements Solution {

    /**
     * @see #traverseLevels(TreeNode, Function, BiConsumer)
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] sequential = new boolean[1];
        traverseLevels(root, size -> {
            LinkedList<Integer> level = new LinkedList<>();
            res.add(level);
            sequential[0] = !sequential[0];
            return level;
        }, (level, val) -> {
            if (sequential[0]) {
                level.addLast(val);
            } else {
                level.addFirst(val);
            }
            res.add(level);
        });
        return res;
    }
}
