package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array/">88. Merge Sorted Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution21
 * @see cn.kingen.oj.leetcode.problem.p900.Solution977
 * @see cn.kingen.oj.leetcode.problem.p900.Solution986
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.SORTING},
        difficulty = Difficulty.EASY
)
public class Solution88 {

    @Complexity(time = "O(m+n)", space = "O(1)")
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}