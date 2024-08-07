package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/">977. Squares of a Sorted Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution88
 * @see cn.kingen.oj.leetcode.problem.p300.Solution360
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.SORTING},
        difficulty = Difficulty.EASY
)
public class Solution977 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] sortedSquares(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n && nums[i] < 0) {
            nums[i] = -nums[i];
            i++;
        }
        int[] ans = new int[n];
        int j = i - 1, k = 0;
        while (j >= 0 && i < n) {
            if (nums[i] < nums[j]) {
                ans[k++] = nums[i] * nums[i++];
            } else {
                ans[k++] = nums[j] * nums[j--];
            }
        }
        while (i < n) {
            ans[k++] = nums[i] * nums[i++];
        }
        while (j >= 0) {
            ans[k++] = nums[j] * nums[j--];
        }
        return ans;
    }
}