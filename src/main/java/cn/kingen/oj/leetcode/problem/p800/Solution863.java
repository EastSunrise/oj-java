package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/all-nodes-distance-k-in-binary-tree/">863. All Nodes Distance K in Binary Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2385
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.HASH_TABLE, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM,
        contest = 91
)
public class Solution863 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> parents = new ArrayList<>();
        List<Boolean> isLeft = new ArrayList<>();
        findParents(parents, isLeft, root, target.val);
        int n = parents.size();

        List<Integer> ans = new ArrayList<>();
        dfs(ans, target, k);

        for (int i = 0; i < n; i++) {
            if (i + 1 == k) {
                ans.add(parents.get(i).val);
                break;
            }

            TreeNode p = parents.get(i);
            if (isLeft.get(i)) { // check the other side
                dfs(ans, p.right, k - i - 2);
            } else {
                dfs(ans, p.left, k - i - 2);
            }
        }
        return ans;
    }

    private boolean findParents(List<TreeNode> parents, List<Boolean> isLeft, TreeNode t, int target) {
        if (t == null) {
            return false;
        }
        if (t.val == target) {
            return true;
        }
        if (findParents(parents, isLeft, t.left, target)) {
            parents.add(t);
            isLeft.add(true);
            return true;
        }
        if (findParents(parents, isLeft, t.right, target)) {
            parents.add(t);
            isLeft.add(false);
            return true;
        }
        return false;
    }

    private void dfs(List<Integer> ans, TreeNode t, int k) {
        if (t == null) {
            return;
        }
        if (k == 0) {
            ans.add(t.val);
            return;
        }
        dfs(ans, t.left, k - 1);
        dfs(ans, t.right, k - 1);
    }
}