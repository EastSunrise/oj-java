package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/longest-alternating-subarray/">2765. Longest Alternating Subarray</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p900.Solution978
 */
@Question(
        tags = {Tag.ARRAY, Tag.ENUMERATION},
        difficulty = Difficulty.EASY
)
public class Solution2765 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int alternatingSubarray(int[] nums) {
        int n = nums.length, i = 1;
        int ans = -1;
        while (i < n) {
            int dif = nums[i] - nums[i - 1];
            if (dif == 1) {
                int j = i + 1;
                while (j < n && nums[j] - nums[j - 1] == -dif) {
                    j++;
                    dif = -dif;
                }
                ans = Math.max(ans, j - i + 1);
                i = j;
            } else {
                i++;
            }
        }
        return ans;
    }
}