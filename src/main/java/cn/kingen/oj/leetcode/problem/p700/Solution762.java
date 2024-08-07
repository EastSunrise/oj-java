package cn.kingen.oj.leetcode.problem.p700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/">762. Prime Number of Set Bits in Binary Representation</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution191
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Solution762 {

    @Complexity(time = "O(r-l)", space = "O(32)")
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> set = Set.of(2, 3, 5, 7, 11, 13, 17, 19);
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (set.contains(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }
}