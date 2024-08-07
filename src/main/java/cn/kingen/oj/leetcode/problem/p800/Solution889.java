package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/">889. Construct Binary Tree from Preorder and Postorder Traversal</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.TREE, Tag.ARRAY, Tag.HASH_TABLE, Tag.DIVIDE_AND_CONQUER, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution889 {

    @Complexity(time = "O(n)", space = "O(n)")
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        Map<Integer, Integer> indices = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            indices.put(postorder[i], i);
        }
        return constructFromPrePost(preorder, 0, indices, 0, n);
    }

    private TreeNode constructFromPrePost(int[] preorder, int i, Map<Integer, Integer> postorder, int j, int len) {
        TreeNode node = new TreeNode(preorder[i]);
        if (len == 1) {
            return node;
        }
        // find the index of the left subtree in the postorder
        int k = postorder.get(preorder[i + 1]);
        int leftLen = k - j + 1;
        if (leftLen > 0) {
            // left subtree
            node.left = constructFromPrePost(preorder, i + 1, postorder, j, leftLen);
        }
        int rightLen = len - leftLen - 1;
        if (rightLen > 0) {
            // right subtree
            node.right = constructFromPrePost(preorder, i + leftLen + 1, postorder, k + 1, rightLen);
        }
        return node;
    }
}