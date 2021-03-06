package wsg.oj.java.leetcode.problems.old;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import wsg.oj.java.datastructure.TreeNode;

/**
 * @author Kingen
 */
public class TreeSolution {

    // 513. 找树左下角的值
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            res = queue.element().val;
            Queue<TreeNode> cur = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    cur.add(node.left);
                }
                if (node.right != null) {
                    cur.add(node.right);
                }
            }
            queue = cur;
        }
        return res;
    }

    // 662. 二叉树最大宽度
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 1;
        while (!queue.isEmpty()) {
            Deque<TreeNode> nextLevel = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    nextLevel.add(null);
                    nextLevel.add(null);
                } else {
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                }
            }
            while (!nextLevel.isEmpty() && nextLevel.peek() == null) {
                nextLevel.poll();
            }
            while (!nextLevel.isEmpty() && nextLevel.peekLast() == null) {
                nextLevel.pollLast();
            }
            if (nextLevel.size() > max) {
                max = nextLevel.size();
            }
            queue = nextLevel;
        }
        return max;
    }

    // wsg 687. 最长同值路径
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left, right = root.right;
        int leftLen = longestUnivaluePath(left), rightLen = longestUnivaluePath(right);
        if (left != null && left.val == root.val && right != null && right.val == root.val) {
            return leftLen + rightLen + 2;
        } else if (left != null && left.val == root.val) {
            return Math.max(leftLen + 1, rightLen);
        } else if (right != null && right.val == root.val) {
            return Math.max(leftLen, rightLen + 1);
        }
        return Math.max(leftLen, rightLen);
    }

    // 951. 翻转等价二叉树
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 != null) {
            if (root2 != null) {
                if (root1.val == root2.val) {
                    return
                        (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                            || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right,
                            root2.left));
                }
            }
        }
        return false;
    }
}
