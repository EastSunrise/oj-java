package wsg.oj.java.leetcode.problems.p100;

import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.base.TreeNode;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal (Medium)
 *
 * @author Kingen
 * @see Solution105
 * @see <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">Construct
 * Binary Tree from Inorder and Postorder Traversal</a>
 * @since 2021-07-11
 */
public class Solution106 implements Solution {

    /**
     * Builds the tree recursively.
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, postorder, 0, postorder.length);
    }

    /**
     * Builds a subtree.
     *
     * @param si  the start index of the subtree in the inorder
     * @param sp  the start index of the subtree in the postorder
     * @param len the total numbers of nodes in the subtree
     * @return the root of the subtree
     */
    private TreeNode buildTree(int[] inorder, int si, int[] postorder, int sp, int len) {
        TreeNode node = new TreeNode(postorder[sp + len - 1]);
        // find the index of the root node in the inorder
        int ri = si;
        while (inorder[ri] != node.val) {
            ri++;
        }
        int leftLen = ri - si;
        if (leftLen > 0) {
            // there is left child node
            node.left = buildTree(inorder, si, postorder, sp, leftLen);
        }
        int rightLen = len - leftLen - 1;
        if (rightLen > 0) {
            // there is right child node
            node.right = buildTree(inorder, si + leftLen + 1, postorder, sp + leftLen, rightLen);
        }
        return node;
    }

    /**
     * Builds the tree iteratively.
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        int len = postorder.length;
        TreeNode root = new TreeNode(postorder[len - 1]);
        Stack<TreeNode> stack = new Stack<>();
        int inIdx = inorder.length - 1;
        stack.push(root);
        for (int i = len - 2; i >= 0; i--) {
            TreeNode node = stack.peek();
            if (inorder[inIdx] != node.val) {
                // there is a right child node
                node.right = new TreeNode(postorder[i]);
                stack.push(node.right);
            } else {
                // reach the rightmost leaf node, rollback to ancestor node that has left subtree
                do {
                    node = stack.pop();
                    inIdx--;
                } while (!stack.isEmpty() && stack.peek().val == inorder[inIdx]);
                node.left = new TreeNode(postorder[i]);
                stack.push(node.left);
            }
        }
        return root;
    }
}
