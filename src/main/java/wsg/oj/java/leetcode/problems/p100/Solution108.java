package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.datastructure.TreeNode;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 108. Convert Sorted Array to Binary Search Tree (Easy)
 *
 * @author Kingen
 * @see Solution109
 * @see <a href="https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/">Convert
 * Sorted Array to Binary Search Tree</a>
 * @since 2021-07-11
 */
class Solution108 implements Solution {

    /**
     * @see #POSTORDER
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_H
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
