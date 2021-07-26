package wsg.oj.java.leetcode.problems.p600;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p0.Solution1;
import wsg.oj.java.leetcode.problems.p100.Solution167;

/**
 * 653. Two Sum IV - Input is a BST (EASY)
 *
 * @author Kingen
 * @see Solution1
 * @see Solution167
 * @see Solution170
 * @see Solution1214
 * @see <a href="https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/">Two Sum IV - Input is
 * a BST</a>
 * @since 2021-07-23
 */
public class Solution653 extends BinaryTree implements Solution {

    /**
     * @see #PREORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> visited = new HashSet<>();
        return traverse(root, visited, k);
    }

    private boolean traverse(TreeNode node, Set<Integer> visited, int k) {
        if (visited.contains(k - node.val)) {
            return true;
        }
        visited.add(node.val);
        if (node.left != null && traverse(node.left, visited, k)) {
            return true;
        }
        return node.right != null && traverse(node.right, visited, k);
    }

    /**
     * @see #INORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public boolean findTarget2(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorderTraversal(root.left, list);
            list.add(root.val);
            inorderTraversal(root.right, list);
        }
    }
}
