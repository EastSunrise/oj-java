package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">106. Construct Binary Tree from Inorder and Postorder Traversal</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution105
 */
@Question(
        tags = {Tag.TREE, Tag.ARRAY, Tag.HASH_TABLE, Tag.DIVIDE_AND_CONQUER, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution106 {

    @Complexity(time = "O(n)", space = "O(n)")
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        Map<Integer, Integer> indices = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            indices.put(inorder[i], i);
        }
        return buildTree(indices, 0, postorder, 0, postorder.length);
    }

    /**
     * Builds the tree recursively.
     *
     * @param si  the start index of the subtree in the inorder
     * @param sp  the start index of the subtree in the postorder
     * @param len the total numbers of nodes in the subtree
     * @return the root of the subtree
     */
    private TreeNode buildTree(Map<Integer, Integer> inorder, int si, int[] postorder, int sp, int len) {
        TreeNode node = new TreeNode(postorder[sp + len - 1]);
        // find the index of the root node in the inorder
        int ri = inorder.get(node.val);
        int leftLen = ri - si;
        if (leftLen > 0) {
            // left subtree
            node.left = buildTree(inorder, si, postorder, sp, leftLen);
        }
        int rightLen = len - leftLen - 1;
        if (rightLen > 0) {
            // right subtree
            node.right = buildTree(inorder, si + leftLen + 1, postorder, sp + leftLen, rightLen);
        }
        return node;
    }

    /**
     * Builds the tree iteratively.
     */
    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
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