package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-alternating-subarrays/">3101. Count Alternating Subarrays</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution3101 {

    @Complexity(time = "O(n)", space = "O(1)")
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        // prev: the count of alternating subarrays ending at i
        long ans = 1, prev = 1;
        for (int i = 1; i < n; i++) {
            long cur = nums[i] == nums[i - 1] ? 1 : prev + 1;
            ans += cur;
            prev = cur;
        }
        return ans;
    }
}