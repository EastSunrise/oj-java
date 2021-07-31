package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution102;

/**
 * 993. Cousins in Binary Tree (EASY)
 *
 * @author Kingen
 * @see Solution102
 * @see <a href="https://leetcode-cn.com/problems/cousins-in-binary-tree/">Cousins in Binary
 * Tree</a>
 * @since 2021-07-27
 */
public class Solution993 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        int xi = findIndex(root, 1, x);
        int yi = findIndex(root, 1, y);
        int dx = (int) (Math.log(xi) / Math.log(2));
        int dy = (int) (Math.log(yi) / Math.log(2));
        return dx == dy && xi / 2 != yi / 2;
    }

    private int findIndex(TreeNode node, int idx, int target) {
        if (node == null) {
            return -1;
        }
        if (node.val == target) {
            return idx;
        }
        int left = findIndex(node.left, 2 * idx, target);
        if (left >= 0) {
            return left;
        }
        int right = findIndex(node.right, 2 * idx + 1, target);
        if (right >= 0) {
            return right;
        }
        return -1;
    }
}
