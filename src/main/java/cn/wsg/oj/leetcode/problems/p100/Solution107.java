package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p600.Solution637;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. Binary Tree Level Order Traversal II (Medium)
 *
 * @author Kingen
 * @see Solution102
 * @see Solution637
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/">Binary Tree
 * Level Order Traversal II</a>
 */
public class Solution107 implements Solution {

    /**
     * @see #LEVEL_ORDER
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // traverse a level
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.addFirst(level);
        }
        return res;
    }
}
