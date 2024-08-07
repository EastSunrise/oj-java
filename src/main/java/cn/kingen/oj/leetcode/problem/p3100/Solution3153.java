package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/sum-of-digit-differences-of-all-pairs/">3153. Sum of Digit Differences of All Pairs</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution477
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.MATH, Tag.COUNTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3153 {

    @Complexity(time = "O(kn+kC)", space = "O(C)", note = "C is 10 and k is the number of digits")
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        int[] count = new int[10];
        long ans = 0;
        while (nums[0] > 0) {
            for (int i = 0; i < n; i++) {
                count[nums[i] % 10]++;
                nums[i] /= 10;
            }
            long sum = 0;
            for (int i = 0; i < 10; i++) {
                ans += count[i] * sum;
                sum += count[i];
            }
            Arrays.fill(count, 0);
        }
        return ans;
    }
}