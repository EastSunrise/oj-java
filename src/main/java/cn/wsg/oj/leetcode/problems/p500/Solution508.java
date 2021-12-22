package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. Most Frequent Subtree Sum (MEDIUM)
 *
 * @author Kingen
 * @see Solution572
 * @see <a href="https://leetcode-cn.com/problems/most-frequent-subtree-sum/">Most Frequent Subtree
 * Sum</a>
 */
public class Solution508 implements Solution {

    /**
     * @see #POSTORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sums = new HashMap<>(16);
        sum(root, sums);
        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : sums.entrySet()) {
            int count = entry.getValue();
            if (count > max) {
                max = count;
                res.clear();
                res.add(entry.getKey());
            } else if (count == max) {
                res.add(entry.getKey());
            }
        }
        return toArray(res);
    }

    private int sum(TreeNode node, Map<Integer, Integer> sums) {
        int left = node.left == null ? 0 : sum(node.left, sums);
        int right = node.right == null ? 0 : sum(node.right, sums);
        int sum = node.val + left + right;
        sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
