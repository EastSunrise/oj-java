package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/single-number/">136. Single Number</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution137
 * @see cn.kingen.oj.leetcode.problem.p200.Solution260
 * @see cn.kingen.oj.leetcode.problem.p200.Solution268
 * @see cn.kingen.oj.leetcode.problem.p200.Solution287
 * @see cn.kingen.oj.leetcode.problem.p300.Solution389
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY},
        difficulty = Difficulty.EASY
)
public class Solution136 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}