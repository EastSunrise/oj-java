package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-xor-of-numbers-which-appear-twice/">3158. Find the XOR of Numbers Which Appear Twice</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution136
 * @see cn.kingen.oj.leetcode.problem.p100.Solution137
 * @see cn.kingen.oj.leetcode.problem.p200.Solution260

 */
@Question(
    tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.HASH_TABLE},
    difficulty = Difficulty.EASY
)
public class Solution3158 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int duplicateNumbersXOR(int[] nums) {
        int ans = 0;
        long mask = 0;
        for (int num : nums) {
            if ((mask & (1L << num)) != 0) { // num already exists
                ans ^= num;
            } else {
                mask |= 1L << num;
            }
        }
        return ans;
    }
}