package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-i/">3038. Maximum Number of Operations With the Same Score I</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution3038 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maxOperations(int[] nums) {
        int n = nums.length, i = 2;
        int score = nums[0] + nums[1];
        while (n - i >= 2 && nums[i] + nums[i + 1] == score) {
            i += 2;
        }
        return i / 2;
    }
}