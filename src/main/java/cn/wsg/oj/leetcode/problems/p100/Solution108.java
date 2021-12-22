package cn.wsg.oj.leetcode.problems.p100;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.base.TreeNode;

/**
 * 108. Convert Sorted Array to Binary Search Tree (Easy)
 *
 * @author Kingen
 * @see Solution109
 * @see <a href="https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/">Convert
 * Sorted Array to Binary Search Tree</a>
 */
public class Solution108 implements Solution {

    /**
     * @see #POSTORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) >> 1;
        TreeNode left = sortedArrayToBST(nums, low, mid - 1);
        TreeNode right = sortedArrayToBST(nums, mid + 1, high);
        return new TreeNode(nums[mid], left, right);
    }
}
