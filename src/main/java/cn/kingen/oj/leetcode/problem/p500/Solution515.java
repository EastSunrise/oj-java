package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.List;

import static cn.kingen.oj.leetcode.util.TreeUtils.traverseTreeByLevel;

/**
 * <a href="https://leetcode.cn/problems/find-largest-value-in-each-tree-row/">515. Find Largest Value in Each Tree Row</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.BREADTH_FIRST_SEARCH, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution515 {

    @Complexity(time = "O(n)", space = "O(n)")
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverseTreeByLevel(root, (i, values) -> {
            int max = Integer.MIN_VALUE;
            for (int value : values) {
                max = Math.max(max, value);
            }
            ans.add(max);
        });
        return ans;
    }
}