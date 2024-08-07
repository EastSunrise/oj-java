package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-pivot-index/">724. Find Pivot Index</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution560
 */
@Question(
        tags = {Tag.ARRAY, Tag.PREFIX_SUM},
        difficulty = Difficulty.EASY
)
public class Solution724 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        for (int num : nums) {
            right += num;
        }

        for (int i = 0; i < n; i++) {
            right -= nums[i];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}