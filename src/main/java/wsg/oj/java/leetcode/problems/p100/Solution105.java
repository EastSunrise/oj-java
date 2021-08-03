package wsg.oj.java.leetcode.problems.p100;

import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal (Medium)
 *
 * @author Kingen
 * @see Solution106
 * @see <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Construct
 * Binary Tree from Preorder and Inorder Traversal</a>
 * @since 2021-07-11
 */
public class Solution105 implements Solution {

    /**
     * Builds the tree recursively.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, preorder.length);
    }

    /**
     * Builds a subtree.
     *
     * @param sp  the start index of the subtree in the preorder
     * @param si  the start index of the subtree in the inorder
     * @param len the total numbers of nodes in the subtree
     * @return the root of the subtree
     */
    private TreeNode buildTree(int[] preorder, int sp, int[] inorder, int si, int len) {
        TreeNode node = new TreeNode(preorder[sp]);
        // find the index of the root node in the inorder
        int ri = si;
        while (inorder[ri] != node.val) {
            ri++;
        }
        int leftLen = ri - si;
        if (leftLen > 0) {
            // there is left child node
            node.left = buildTree(preorder, sp + 1, inorder, si, leftLen);
        }
        int rightLen = len - leftLen - 1;
        if (rightLen > 0) {
            // there is right child node
            node.right = buildTree(preorder, sp + 1 + leftLen, inorder, si + leftLen + 1, rightLen);
        }
        return node;
    }

    /**
     * Builds the tree iteratively.
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int len = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        int inIdx = 0;
        stack.push(root);
        for (int i = 1; i < len; i++) {
            TreeNode node = stack.peek();
            if (inorder[inIdx] != node.val) {
                // there is a left child node
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            } else {
                // reach the leftmost leaf node, rollback to ancestor node that has right subtree
                do {
                    node = stack.pop();
                    inIdx++;
                } while (!stack.isEmpty() && stack.peek().val == inorder[inIdx]);
                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }
        return root;
    }
}
