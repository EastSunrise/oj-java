package wsg.oj.java.leetcode.problems.p600;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 655. Print Binary Tree (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/print-binary-tree/">Print Binary Tree</a>
 * @since 2021-07-23
 */
class Solution655 extends BinaryTree implements Solution {

    /**
     * @complexity T=O(h*2^h), h=the height of the tree
     * @complexity S=O(h*2^h)
     */
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        List<List<String>> res = new ArrayList<>(height);
        int width = (int) Math.pow(2, height) - 1;
        print(res, root, 0, 0, width - 1);
        for (List<String> level : res) {
            for (int i = level.size(); i < width; i++) {
                level.add("");
            }
        }
        return res;
    }

    private void print(List<List<String>> res, TreeNode node, int depth, int left, int right) {
        if (res.size() == depth) {
            res.add(new ArrayList<>());
        }
        List<String> level = res.get(depth);
        int mid = (left + right) >>> 1;
        for (int i = level.size(); i < mid; i++) {
            level.add("");
        }
        level.add(String.valueOf(node.val));
        if (node.left != null) {
            print(res, node.left, depth + 1, left, mid - 1);
        }
        if (node.right != null) {
            print(res, node.right, depth + 1, mid + 1, right);
        }
    }
}
