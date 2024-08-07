package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

import static cn.kingen.oj.leetcode.util.ArrayUtils.findKthSmallest;

/**
 * <a href="https://leetcode.cn/problems/wiggle-sort-ii/">324. Wiggle Sort II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution75
 * @see cn.kingen.oj.leetcode.problem.p200.Solution215
 * @see cn.kingen.oj.leetcode.problem.p200.Solution280
 */
@Question(tags = {Tag.ARRAY, Tag.DIVIDE_AND_CONQUER, Tag.QUICKSELECT, Tag.SORTING}, difficulty = Difficulty.MEDIUM)
public class Solution324 {

    @Complexity(time = "O(n)", space = "O(n)")
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int mid = (n + 1) / 2;
        findKthSmallest(nums, mid);
        // insert nums[mid,n) into nums[0,mid)
        int low = mid - 1, high = nums.length - 1;
        int[] copy = Arrays.copyOf(nums, n);
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                nums[i] = copy[low--];
            } else {
                nums[i] = copy[high--];
            }
        }
    }
}