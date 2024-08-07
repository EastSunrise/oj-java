package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/set-mismatch/">645. Set Mismatch</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution287
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.HASH_TABLE, Tag.SORTING},
        difficulty = Difficulty.EASY
)
public class Solution645 {

    /**
     * @see cn.kingen.oj.leetcode.problem.p200.Solution260
     */
    @Complexity(time = "O(n)", space = "O(1)")
    public int[] findErrorNums(int[] nums) {
        int n = nums.length, xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int mask = 1;
        while ((xor & 1) == 0) {
            mask <<= 1;
            xor >>>= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & mask) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        for (int num : nums) {
            if (num == a) {
                return new int[]{a, b};
            }
        }
        return new int[]{b, a};
    }
}