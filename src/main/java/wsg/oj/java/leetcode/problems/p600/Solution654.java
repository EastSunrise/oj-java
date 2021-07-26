package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 654. Maximum Binary Tree (MEDIUM)
 *
 * @author Kingen
 * @see Solution998
 * @see <a href="https://leetcode-cn.com/problems/maximum-binary-tree/">Maximum Binary Tree</a>
 * @since 2021-07-23
 */
public class Solution654 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_H
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    private TreeNode construct(int[] nums, int fromIn, int toEx) {
        if (fromIn >= toEx) {
            return null;
        }
        int max = nums[fromIn], maxi = fromIn;
        for (int i = fromIn + 1; i < toEx; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxi = i;
            }
        }
        return new TreeNode(max, construct(nums, fromIn, maxi), construct(nums, maxi + 1, toEx));
    }
}
