package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/">987. Vertical Order Traversal of a Binary Tree</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.HASH_TABLE, Tag.BINARY_TREE, Tag.SORTING},
        difficulty = Difficulty.HARD
)
public class Solution987 {

    @Complexity(time = "O(n log log n)", space = "O(n)")
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int[] bound = new int[2];
        getWidth(root, 0, bound);
        List<List<List<Integer>>> cols = new ArrayList<>(bound[1] - bound[0] + 1);
        dfs(cols, root, 0, -bound[0]);
        List<List<Integer>> ans = new ArrayList<>(bound[1] - bound[0] + 1);
        for (List<List<Integer>> col : cols) {
            List<Integer> column = new ArrayList<>(col.size());
            for (List<Integer> cell : col) {
                cell.sort(null);
                column.addAll(cell);
            }
            ans.add(column);
        }
        return ans;
    }

    void getWidth(TreeNode t, int c, int[] bound) {
        if (t == null) {
            return;
        }
        bound[0] = Math.min(bound[0], c);
        bound[1] = Math.max(bound[1], c);
        getWidth(t.left, c - 1, bound);
        getWidth(t.right, c + 1, bound);
    }

    void dfs(List<List<List<Integer>>> cols, TreeNode node, int r, int c) {
        if (node == null) {
            return;
        }
        while (cols.size() <= c) {
            cols.add(new ArrayList<>());
        }
        List<List<Integer>> col = cols.get(c);
        while (col.size() <= r) {
            col.add(new ArrayList<>());
        }
        col.get(r).add(node.val);
        dfs(cols, node.left, r + 1, c - 1);
        dfs(cols, node.right, r + 1, c + 1);
    }
}