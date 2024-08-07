package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-prime-difference/">3115. Maximum Prime Difference</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.NUMBER_THEORY},
        difficulty = Difficulty.MEDIUM
)
public class Solution3115 {

    private static final boolean[] NOT_PRIME = new boolean[101];

    static {
        NOT_PRIME[1] = true;
        for (int i = 2; i * i < NOT_PRIME.length; i++) {
            if (NOT_PRIME[i]) {
                continue;
            }
            for (int j = i * i; j < NOT_PRIME.length; j += i) {
                NOT_PRIME[j] = true;
            }
        }
    }

    @Complexity(time = "O(n+K)", space = "O(C)", note = "C is the range of numbers and K=O(C*log{C}*log{C})")
    public int maximumPrimeDifference(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j && NOT_PRIME[nums[i]]) {
            i++;
        }
        while (j >= i && NOT_PRIME[nums[j]]) {
            j--;
        }
        return j - i;
    }
}