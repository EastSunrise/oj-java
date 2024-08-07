package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-mode-in-binary-search-tree/">501. Find Mode in Binary Search Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution98
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_SEARCH_TREE, Tag.BINARY_TREE},
        difficulty = Difficulty.EASY
)
public class Solution501 {

    @Complexity(time = "O(n)", space = "O(h)", note = "h is the height of the tree")
    public int[] findMode(TreeNode root) {
        // tmp: current number, count of current number, count of each mode
        int[] tmp = new int[3];
        List<Integer> modes = new ArrayList<>();
        dfs(modes, root, tmp);
        return modes.stream().mapToInt(t -> t).toArray();
    }

    private void dfs(List<Integer> modes, TreeNode t, int[] tmp) {
        if (t == null) {
            return;
        }
        dfs(modes, t.left, tmp);
        if (t.val == tmp[0]) {
            tmp[1]++;
        } else {
            tmp[0] = t.val;
            tmp[1] = 1;
        }
        if (tmp[1] > tmp[2]) {
            modes.clear();
            modes.add(tmp[0]);
            tmp[2] = tmp[1];
        } else if (tmp[1] == tmp[2]) {
            modes.add(tmp[0]);
        }
        dfs(modes, t.right, tmp);
    }
}