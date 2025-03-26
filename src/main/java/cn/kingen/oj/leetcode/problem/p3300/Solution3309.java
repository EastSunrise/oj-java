package cn.kingen.oj.leetcode.problem.p3300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-possible-number-by-binary-concatenation/">3309. Maximum Possible Number by Binary Concatenation</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1680

 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.ENUMERATION},
        difficulty = Difficulty.MEDIUM,
        contest = 418
)
public class Solution3309 {

    @Complexity(time = "O(n!)", space = "O(1)")
    public int maxGoodNumber(int[] nums) {
        int c0 = maxGoodNumber(nums[0], maxGoodNumber(nums[1], nums[2]));
        int c1 = maxGoodNumber(nums[1], maxGoodNumber(nums[0], nums[2]));
        int c2 = maxGoodNumber(nums[2], maxGoodNumber(nums[0], nums[1]));
        return Math.max(c0, Math.max(c1, c2));
    }

    private int maxGoodNumber(int x, int y) {
        return Math.max(x << (32 - Integer.numberOfLeadingZeros(y)) | y, y << (32 - Integer.numberOfLeadingZeros(x)) | x);
    }
}