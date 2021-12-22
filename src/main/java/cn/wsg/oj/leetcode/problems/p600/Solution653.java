package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p0.Solution1;
import cn.wsg.oj.leetcode.problems.p100.Solution167;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
 */
public class Solution653 implements Solution {

    /**
     * @see #PREORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
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
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public boolean findTarget2(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);
        int left = 0, right = values.size() - 1;
        while (left < right) {
            int sum = values.get(left) + values.get(right);
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
