package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">105. Construct Binary Tree from Preorder and Inorder Traversal</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution106
 */
@Question(
        tags = {Tag.TREE, Tag.ARRAY, Tag.HASH_TABLE, Tag.DIVIDE_AND_CONQUER, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution105 {

    @Complexity(time = "O(n)", space = "O(n)")
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> indices = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            indices.put(inorder[i], i);
        }
        return buildTree(preorder, 0, indices, 0, n);
    }

    /**
     * Builds the tree recursively.
     *
     * @param sp  the start index of the tree in the preorder
     * @param si  the start index of the tree in the inorder
     * @param len the total numbers of nodes in the tree
     * @return the root of the tree
     */
    private TreeNode buildTree(int[] preorder, int sp, Map<Integer, Integer> inorder, int si, int len) {
        TreeNode node = new TreeNode(preorder[sp]);
        // find the index of the root node in the inorder
        int ri = inorder.get(node.val);
        int leftLen = ri - si;
        if (leftLen > 0) {
            // left subtree
            node.left = buildTree(preorder, sp + 1, inorder, si, leftLen);
        }
        int rightLen = len - leftLen - 1;
        if (rightLen > 0) {
            // right subtree
            node.right = buildTree(preorder, sp + 1 + leftLen, inorder, si + leftLen + 1, rightLen);
        }
        return node;
    }

    /**
     * Builds the tree iteratively.
     */
    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public TreeNode buildTree_2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        int inIdx = 0;
        stack.push(root);
        for (int i = 1; i < n; i++) {
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