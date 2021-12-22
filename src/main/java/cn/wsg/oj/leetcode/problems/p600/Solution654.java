package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 654. Maximum Binary Tree (MEDIUM)
 *
 * @author Kingen
 * @see Solution998
 * @see <a href="https://leetcode-cn.com/problems/maximum-binary-tree/">Maximum Binary Tree</a>
 */
public class Solution654 implements Solution {

    /**
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_H
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
