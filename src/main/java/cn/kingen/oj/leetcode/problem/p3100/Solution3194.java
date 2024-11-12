package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-average-of-smallest-and-largest-elements/">3194. Minimum Average of Smallest and Largest Elements</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2465
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.SORTING},
        difficulty = Difficulty.EASY
)
public class Solution3194 {

    @Complexity(time = "O(n log n)", space = "O(1)")
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            min = Math.min(min, nums[i] + nums[j]);
        }
        return min / 2.0;
    }
}