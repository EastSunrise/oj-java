package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal (Medium)
 *
 * @author Kingen
 * @see Solution102
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/">Binary
 * Tree Zigzag Level Order Traversal</a>
 */
public class Solution103 implements Solution {

    /**
     * @see #LEVEL_ORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean inverted = false;
        while (!queue.isEmpty()) {
            // traverse a level
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (inverted) {
                    level.addFirst(node.val);
                } else {
                    level.addLast(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
            inverted = !inverted;
        }
        return res;
    }
}
