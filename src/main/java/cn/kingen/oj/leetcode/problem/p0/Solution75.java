package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/sort-colors/">75. Sort Colors</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution148
 * @see cn.kingen.oj.leetcode.problem.p200.Solution280
 * @see cn.kingen.oj.leetcode.problem.p300.Solution324
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution75 {

    @Complexity(time = "O(n)", space = "O(1)")
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == 0) {
                i++;
            } else if (nums[j] != 0) {
                j--;
            } else {
                nums[j--] = nums[i];
                nums[i++] = 0;
            }
        }
        j = nums.length - 1;
        while (i < j) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[j] == 2) {
                j--;
            } else {
                nums[i++] = 1;
                nums[j--] = 2;
            }
        }
    }
}