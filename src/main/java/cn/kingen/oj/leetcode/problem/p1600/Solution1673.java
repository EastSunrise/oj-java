package cn.kingen.oj.leetcode.problem.p1600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;


/**
 * <a href="https://leetcode.cn/problems/find-the-most-competitive-subsequence/">1673. Find the Most Competitive Subsequence</a>
 *
 * @author Kingen
 */
@Question(
        tags = {
                Tag.STACK, Tag.GREEDY, Tag.ARRAY, Tag.MONOTONIC_STACK
        },
        difficulty = Difficulty.MEDIUM
)
public class Solution1673 {

    @Complexity(time = "O(n)", space = "O(k)")
    public int[] mostCompetitive(int[] nums, int k) {
        int[] ans = new int[k];
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && ans[j - 1] > nums[i] && i < n - k + j) {
                j--;
            }
            if (j < k) {
                ans[j++] = nums[i];
            }
        }
        return ans;
    }
}