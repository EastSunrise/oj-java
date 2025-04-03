package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-ii/">2874. Maximum Value of an Ordered Triplet II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution42
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2012
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2909
 */
@Question(
    tags = {Tag.ARRAY},
    difficulty = Difficulty.MEDIUM,
    date = "2025-04-03"
)
public class Solution2874 {

    @Complexity(time = "O(n)", space = "O(1)")
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int mxi = 0, maxGap = 0;
        for (int num : nums) {
            ans = Math.max(ans, (long) maxGap * num);
            maxGap = Math.max(maxGap, mxi - num);
            mxi = Math.max(mxi, num);
        }
        return ans;
    }
}