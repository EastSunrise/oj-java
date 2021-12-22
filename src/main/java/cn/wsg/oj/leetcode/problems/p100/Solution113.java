package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import cn.wsg.oj.leetcode.problems.p200.Solution257;
import cn.wsg.oj.leetcode.problems.p400.Solution437;
import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II (Medium)
 *
 * @author Kingen
 * @see Solution112
 * @see Solution257
 * @see Solution437
 * @see Solution666
 * @see <a href="https://leetcode-cn.com/problems/path-sum-ii/">Path Sum II</a>
 */
public class Solution113 implements Solution {

    /**
     * @see #PREORDER
     * @see #BACKTRACKING
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(res, root, new ArrayList<>(), targetSum);
        return res;
    }

    private void pathSum(List<List<Integer>> res, TreeNode node, List<Integer> tmp, int target) {
        if (node == null) {
            return;
        }
        tmp.add(node.val);
        target -= node.val;
        if (node.left == null && node.right == null && target == 0) {
            // find a path
            res.add(new ArrayList<>(tmp));
        }
        pathSum(res, node.left, tmp, target);
        pathSum(res, node.right, tmp, target);
        tmp.remove(tmp.size() - 1);
    }
}
