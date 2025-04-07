package cn.kingen.oj.leetcode.problem.p1800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/sum-of-all-subset-xor-totals/">1863. Sum of All Subset XOR Totals</a>
 *
 * @author Kingen
 */
@Question(
    tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.MATH, Tag.BACKTRACKING, Tag.COMBINATORICS, Tag.ENUMERATION},
    difficulty = Difficulty.EASY,
    date = "2025-04-05"
)
public class Solution1863 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int subsetXORSum(int[] nums) {
        int or = 0;
        for (int num : nums) {
            or |= num;
        }
        return or << (nums.length - 1);
    }
}