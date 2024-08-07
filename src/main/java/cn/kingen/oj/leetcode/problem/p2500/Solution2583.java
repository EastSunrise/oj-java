package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static java.util.Collections.swap;

/**
 * <a href="https://leetcode.cn/problems/kth-largest-sum-in-a-binary-tree/">2583. Kth Largest Sum in a Binary Tree</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution144
 * @see cn.kingen.oj.leetcode.problem.p1100.Solution1161
 * @see cn.kingen.oj.leetcode.problem.p3100.Solution3157
 */
@Question(
        tags = {Tag.TREE, Tag.BREADTH_FIRST_SEARCH, Tag.BINARY_TREE, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2583 {

    @Complexity(time = "O(n)", space = "O(n)")
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Long> sums = new ArrayList<>(k);
        queue.offer(root);
        while (!queue.isEmpty()) {
            long sum = 0;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode current = queue.remove();
                sum += current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            sums.add(sum);
        }
        if (sums.size() < k) {
            return -1;
        }
        return findKthLargest(sums, k, 0, sums.size());
    }

    private long findKthLargest(List<Long> vs, int k, int fromIn, int toEx) {
        int pivot = (int) (Math.random() * (toEx - fromIn) + fromIn);
        swap(vs, pivot, fromIn);
        int low = fromIn + 1, high = toEx - 1;
        while (low <= high) {
            if (vs.get(low) >= vs.get(fromIn)) {
                low++;
            } else if (vs.get(fromIn) > vs.get(high)) {
                high--;
            } else {
                swap(vs, low++, high--);
            }
        }
        swap(vs, fromIn, high);
        if (k == low) {
            return vs.get(high);
        }
        if (k < low) {
            return findKthLargest(vs, k, fromIn, high);
        }
        return findKthLargest(vs, k, low, toEx);
    }
}