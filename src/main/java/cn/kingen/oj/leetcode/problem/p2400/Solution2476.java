package cn.kingen.oj.leetcode.problem.p2400;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/closest-nodes-queries-in-a-binary-search-tree/">2476. Closest Nodes Queries in a Binary Search Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution270
 * @see cn.kingen.oj.leetcode.problem.p200.Solution272
 * @see cn.kingen.oj.leetcode.problem.p700.Solution700
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BINARY_SEARCH_TREE, Tag.ARRAY, Tag.BINARY_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution2476 {

    @Complexity(time = "O(n+q log(n))", space = "O(n)")
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        while (t != null || !stack.isEmpty()) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            values.add(t.val);
            t = t.right;
        }

        List<List<Integer>> ans = new ArrayList<>(queries.size());
        for (int key : queries) {
            int i = Collections.binarySearch(values, key);
            if (i >= 0) {
                ans.add(List.of(key, key));
            } else {
                i = -(i + 1);
                int min = i == 0 ? -1 : values.get(i - 1);
                int max = i == values.size() ? -1 : values.get(i);
                ans.add(List.of(min, max));
            }
        }
        return ans;
    }
}