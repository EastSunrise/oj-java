package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-if-array-can-be-sorted/">3011. Find if Array Can Be Sorted</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1300.Solution1356
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3011 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        boolean asc = true;
        int prevMax = -1;
        for (int i = 0; i < n; ) {
            int bit = Integer.bitCount(nums[i]);
            int j = i + 1, min = nums[i], max = nums[i];
            while (j < n && Integer.bitCount(nums[j]) == bit) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                j++;
            }

            if (min < prevMax) {
                asc = false;
                break;
            }
            prevMax = max;
            i = j;
        }
        return asc;
    }
}