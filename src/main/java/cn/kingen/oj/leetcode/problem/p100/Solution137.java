package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;


/**
 * <a href="https://leetcode.cn/problems/single-number-ii/">137. Single Number II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution136
 * @see cn.kingen.oj.leetcode.problem.p200.Solution260
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY},
        difficulty = Difficulty.MEDIUM
)
public class Solution137 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int singleNumber(int[] nums) {
        // (0,0)->(x,0)->(0,x)->(0,0)
        int a = 0, b = 0;
        for (int x : nums) {
            a = (x ^ a) & ~b;
            b = (x ^ b) & ~a;
        }
        return a;
    }
}