package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/sum-of-good-numbers/">3452. Sum of Good Numbers</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.ARRAY},
        difficulty = Difficulty.EASY,
        contest2 = 150
)
public class Solution3452 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int sumOfGoodNumbers(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            if ((i - k < 0 || nums[i] > nums[i - k]) && (i + k >= n || nums[i] > nums[i + k])) {
                ans += nums[i];
            }
        }
        return ans;
    }
}