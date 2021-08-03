package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 222. Count Complete Tree Nodes (Medium)
 *
 * @author Kingen
 * @see Solution270
 * @see <a href="https://leetcode-cn.com/problems/count-complete-tree-nodes/">Count Complete Tree
 * Nodes</a>
 * @since 2021-07-13
 */
class Solution222 implements Solution {

    /**
     * Finds the root node of the rightmost node in the last level.
     *
     * @complexity T=O(h*h), h=height of the tree
     * @see #BINARY_SEARCH
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        if (left == null) {
            return 1;
        }
        int level = 1;
        while (left != null) {
            left = left.left;
            level++;
        }
        // count of nodes except the last level
        int count = (1 << (level - 1)) - 1;
        TreeNode cur = root;
        while (level > 2) {
            TreeNode mid = cur.left;
            for (int i = 3; i < level; i++) {
                mid = mid.right;
            }
            if (mid.left == null) {
                cur = cur.left;
            } else if (mid.right != null) {
                // the left subtree is complete
                cur = cur.right;
                // plus the last level of the left subtree
                count += 1 << (level - 2);
            } else {
                // find the rightmost node of the last level
                return count + (1 << (level - 2)) - 1;
            }
            level--;
        }

        if (cur.right != null) {
            count += 2;
        } else if (cur.left != null) {
            count++;
        }
        return count;
    }
}
