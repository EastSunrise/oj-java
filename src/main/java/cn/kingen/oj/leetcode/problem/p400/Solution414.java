package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/third-maximum-number/">414. Third Maximum Number</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution215
 */
@Question(
        tags = {Tag.ARRAY, Tag.SORTING},
        difficulty = Difficulty.EASY
)
public class Solution414 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int thirdMax(int[] nums) {
        int max = nums[0];
        Integer max2 = null, max3 = null;
        for (int num : nums) {
            if (num > max) {
                max3 = max2;
                max2 = max;
                max = num;
            } else if (num < max) {
                if (max2 == null) {
                    max2 = num;
                } else if (num > max2) {
                    max3 = max2;
                    max2 = num;
                } else if (num < max2 && (max3 == null || num > max3)) {
                    max3 = num;
                }
            }
        }
        return max3 == null ? max : max3;
    }
}