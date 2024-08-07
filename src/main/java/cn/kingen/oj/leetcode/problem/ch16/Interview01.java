package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/swap-numbers-lcci/">面试题 16.01. Swap Numbers LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Interview01 {

    @Complexity(time = "O(1)", space = "O(1)")
    public int[] swapNumbers(int[] numbers) {
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }
}