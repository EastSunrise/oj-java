package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-maximum-divisibility-score/">2644. Find the Maximum Divisibility Score</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1018
 */
@Question(
        tags = {Tag.ARRAY},
        difficulty = Difficulty.EASY
)
public class Solution2644 {

    @Complexity(time = "O(mn)", space = "O(1)")
    public int maxDivScore(int[] nums, int[] divisors) {
        int ans = Integer.MAX_VALUE, count = -1;
        for (int divisor : divisors) {
            int cnt = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    cnt++;
                }
            }
            if (cnt > count) {
                ans = divisor;
                count = cnt;
            } else if (cnt == count) {
                ans = Math.min(ans, divisor);
            }
        }
        return ans;
    }
}