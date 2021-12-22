package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 863. All Nodes Distance K in Binary Tree (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/">All Nodes
 * Distance K in Binary Tree</a>
 */
public class Solution863 implements Solution {

    Map<Integer, TreeNode> parents = new HashMap<>();

    /**
     * @see #DFS
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root, target.val);
        List<Integer> res = new ArrayList<>();
        dfs(res, target, null, k);
        return res;
    }

    private int findParents(TreeNode node, int target) {
        if (node == null) {
            return -1;
        }
        if (node.val == target) {
            return 0;
        }
        int left = findParents(node.left, target);
        if (left >= 0) {
            // find the target in the left subtree
            parents.put(node.left.val, node);
            return left + 1;
        }
        int right = findParents(node.right, target);
        if (right >= 0) {
            // find the target in the right subtree
            parents.put(node.right.val, node);
            return right + 1;
        }
        return -1;
    }

    private void dfs(List<Integer> res, TreeNode node, TreeNode from, int k) {
        if (node == null) {
            return;
        }
        if (k == 0) {
            res.add(node.val);
            return;
        }
        if (node.left != from) {
            dfs(res, node.left, node, k - 1);
        }
        if (node.right != from) {
            dfs(res, node.right, node, k - 1);
        }
        TreeNode parent = parents.get(node.val);
        if (parent != from) {
            dfs(res, parent, node, k - 1);
        }
    }

    /**
     * @see #POSTORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public List<Integer> distanceK2(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        getDistance(res, root, target.val, k);
        return res;
    }

    private int getDistance(List<Integer> res, TreeNode node, int target, int k) {
        if (node == null) {
            return -1;
        }
        if (node.val == target) {
            collectValue(res, node, k);
            return 0;
        }
        int left = getDistance(res, node.left, target, k);
        if (left >= 0) {
            // find the target in the left subtree
            left++;
            if (left == k) {
                res.add(node.val);
            } else if (left < k) {
                collectValue(res, node.right, k - left - 1);
            }
            return left;
        }
        int right = getDistance(res, node.right, target, k);
        if (right >= 0) {
            // find the target in the right subtree
            right++;
            if (right == k) {
                res.add(node.val);
            } else if (right < k) {
                collectValue(res, node.left, k - right - 1);
            }
            return right;
        }
        return -1;
    }

    private void collectValue(List<Integer> res, TreeNode node, int k) {
        if (node == null) {
            return;
        }
        if (k == 0) {
            res.add(node.val);
            return;
        }
        collectValue(res, node.left, k - 1);
        collectValue(res, node.right, k - 1);
    }
}
