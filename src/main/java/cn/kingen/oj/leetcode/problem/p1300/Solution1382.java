package cn.kingen.oj.leetcode.problem.p1300;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/balance-a-binary-search-tree/">1382. Balance a Binary Search Tree</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_SEARCH_TREE, Tag.DIVIDE_AND_CONQUER, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution1382 {

    @Complexity(time = "O(n)", space = "O(n)")
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        return build(values, 0, values.size());
    }

    private void inorder(TreeNode t, List<Integer> values) {
        if (t != null) {
            inorder(t.left, values);
            values.add(t.val);
            inorder(t.right, values);
        }
    }

    private TreeNode build(List<Integer> values, int fromIn, int toEx) {
        if (fromIn == toEx) {
            return null;
        }
        if (toEx - fromIn == 1) {
            return new TreeNode(values.get(fromIn));
        }
        int mid = fromIn + (toEx - fromIn) / 2;
        return new TreeNode(values.get(mid), build(values, fromIn, mid), build(values, mid + 1, toEx));
    }
}