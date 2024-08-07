package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/single-number-iii/">260. Single Number III</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution136
 * @see cn.kingen.oj.leetcode.problem.p100.Solution137
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY},
        difficulty = Difficulty.MEDIUM
)
public class Solution260 {

    /**
     * <ul>
     *     <li>Calculate xor = nums[0] ^ nums[1] ^ ... ^ nums[n-1] = a ^ b.</li>
     *     <li>Find the position (k) in binary where a and b have different bits.</li>
     *     <li>Divide the array into two parts: one contains the number whose kth bit is 0,
     *     the other contains the number whose kth bit is 1.</li>
     *     <li>The xor of each part is the answer.</li>
     * </ul>
     */
    @Complexity(time = "O(n)", space = "O(1)")
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int mask = xor == Integer.MIN_VALUE ? xor : (xor & -xor);
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}