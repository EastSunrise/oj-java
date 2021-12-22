package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p0.Solution94;
import cn.wsg.oj.leetcode.problems.p600.Solution671;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 230. Kth Smallest Element in a BST (Medium)
 *
 * @author Kingen
 * @see Solution94
 * @see Solution671
 * @see <a href="https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/">Kth Smallest
 * Element in a BST</a>
 */
public class Solution230 implements Solution {

    /**
     * @complexity T=O(k)
     * @complexity S=O(h), h=height of the subtrees of the first k node.
     * @see #INORDER
     */
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode left = root;
        while (left != null) {
            stack.push(left);
            left = left.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (--k == 0) {
                return node.val;
            }
            left = node.right;
            while (left != null) {
                stack.push(left);
                left = left.left;
            }
        }
        throw new IllegalArgumentException("out of range");
    }
}
