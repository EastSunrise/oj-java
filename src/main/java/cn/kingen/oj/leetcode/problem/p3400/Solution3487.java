package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/maximum-unique-subarray-sum-after-deletion/">3487. Maximum Unique Subarray Sum After Deletion</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1100.Solution1186
 */
@Question(
        difficulty = Difficulty.EASY,
        contest = 441
)
public class Solution3487 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            if (num > 0 && set.add(num)) {
                sum += num;
            }
        }
        if (sum > 0) {
            return sum;
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}