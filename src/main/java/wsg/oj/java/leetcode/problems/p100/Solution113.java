package wsg.oj.java.leetcode.problems.p100;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 113. Path Sum II (Medium)
 *
 * @author Kingen
 * @see Solution112
 * @see Solution257
 * @see Solution437
 * @see Solution666
 * @see <a href="https://leetcode-cn.com/problems/path-sum-ii/">Path Sum II</a>
 * @since 2021-07-11
 */
class Solution113 implements Solution {

    /**
     * @see #PREORDER
     * @see #BACKTRACKING
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(res, root, new ArrayList<>(), targetSum);
        return res;
    }

    private void pathSum(List<List<Integer>> res, TreeNode node, List<Integer> temp, int target) {
        if (node == null) {
            return;
        }
        temp.add(node.val);
        target -= node.val;
        if (node.left == null && node.right == null && target == 0) {
            // find a path
            res.add(new ArrayList<>(temp));
        }
        pathSum(res, node.left, temp, target);
        pathSum(res, node.right, temp, target);
        temp.remove(temp.size() - 1);
    }
}
