package cn.kingen.oj.leetcode.util;

import cn.kingen.oj.leetcode.support.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.function.BiConsumer;

/**
 * @author Kingen
 **/
public final class TreeUtils {

    /**
     * Traverses a binary tree by level.
     */
    public static void traverseTreeByLevel(TreeNode root, BiConsumer<Integer, List<Integer>> consumer) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        for (int i = 0; !queue.isEmpty(); i++) {
            List<Integer> values = new ArrayList<>(queue.size());
            for (int j = queue.size(); j > 0; j--) {
                TreeNode t = queue.remove();
                values.add(t.val);
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            consumer.accept(i, values);
        }
    }

    /**
     * Compares two binary trees.
     */
    public static boolean isEqual(TreeNode t1, TreeNode t2) {
        if (t1 == t2) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
    }

    /**
     * Calculates the height of a binary tree.
     */
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}
