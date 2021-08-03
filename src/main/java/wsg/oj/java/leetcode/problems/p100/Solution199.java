package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 199. Binary Tree Right Side View (Medium)
 *
 * @author Kingen
 * @see Solution116
 * @see Solution545
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-right-side-view/">Binary Tree Right
 * Side View</a>
 * @since 2021-07-12
 */
public class Solution199 implements Solution {

    /**
     * @see #LEVEL_ORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return res;
    }
}
