package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-duplicate-subtrees/">652. Find Duplicate Subtrees</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Codec
 * @see cn.kingen.oj.leetcode.problem.p400.Codec
 * @see cn.kingen.oj.leetcode.problem.p600.Solution606
 * @see cn.kingen.oj.leetcode.problem.p1900.Solution1948
 */
@Question(
        tags = {Tag.TREE, Tag.DEPTH_FIRST_SEARCH, Tag.HASH_TABLE, Tag.BINARY_TREE},
        difficulty = Difficulty.MEDIUM
)
public class Solution652 {

    @Complexity(time = "O(n)", space = "O(n)")
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> duplicates = new ArrayList<>();
        traverse(duplicates, new HashMap<>(), root);
        return duplicates;
    }

    private StringBuilder traverse(List<TreeNode> res, Map<String, Integer> counts, TreeNode node) {
        if (node == null) {
            return new StringBuilder("#");
        }
        StringBuilder builder = traverse(res, counts, node.left).append(',')
                .append(traverse(res, counts, node.right)).append(',')
                .append(node.val);
        String str = builder.toString();
        int count = counts.getOrDefault(str, 0);
        if (count == 0) {
            counts.put(str, 1);
        } else if (count == 1) {
            counts.put(str, 2);
            res.add(node);
        }
        return builder;
    }
}