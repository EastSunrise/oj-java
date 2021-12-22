package cn.wsg.oj.leetcode.problems.interview.ch16;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 面试题 16.1. Swap Numbers LCCI (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/swap-numbers-lcci/">Swap Numbers LCCI</a>
 */
public class Interview1 implements Solution {

    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}
