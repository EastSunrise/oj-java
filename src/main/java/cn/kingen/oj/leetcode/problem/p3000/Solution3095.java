package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/shortest-subarray-with-or-at-least-k-i/">3095. Shortest Subarray With OR at Least K I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution209
 * @see cn.kingen.oj.leetcode.problem.p800.Solution862

 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.EASY,
        daily = "2025-01-16"
)
public class Solution3095 {

    @Complexity(time = "O(Cn)", space = "O(C)", note = "C is 32")
    public int minimumSubarrayLength(int[] nums, int k) {
        if (k == 0) {
            return 1;
        }
        int n = nums.length;
        int[] cnt = new int[32];
        int or = 0, ans = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && or < k) {
                for (int b = 0; b < 32; b++) {
                    if ((nums[j] & (1 << b)) != 0) {
                        if (cnt[b]++ == 0) {
                            or |= 1 << b;
                        }
                    }
                }
                j++;
            }
            if (or >= k) {
                ans = Math.min(ans, j - i);
            }
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    if (--cnt[b] == 0) {
                        or &= ~(1 << b);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}