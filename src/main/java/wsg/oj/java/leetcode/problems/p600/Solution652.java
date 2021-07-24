package wsg.oj.java.leetcode.problems.p600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wsg.oj.java.datastructure.BinaryTree;
import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p400.Solution449;

/**
 * 652. Find Duplicate Subtrees (MEDIUM)
 *
 * @author Kingen
 * @see Solution297
 * @see Solution449
 * @see Solution606
 * @see <a href="https://leetcode-cn.com/problems/find-duplicate-subtrees/">Find Duplicate
 * Subtrees</a>
 * @since 2021-07-23
 */
public class Solution652 extends BinaryTree implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_NN
     */
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
