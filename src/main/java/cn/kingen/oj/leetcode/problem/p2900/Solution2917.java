package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-k-or-of-an-array/">2917. Find the K-or of an Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution338
 * @see cn.kingen.oj.leetcode.problem.p2800.Solution2859
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY},
        difficulty = Difficulty.EASY
)
public class Solution2917 {

    @Complexity(time = "n*log{C}", space = "O(1)", note = "C is the binary digits")
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += num >> i & 1;
            }
            if (cnt >= k) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}