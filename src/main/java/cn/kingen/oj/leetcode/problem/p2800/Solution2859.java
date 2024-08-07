package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/sum-of-values-at-indices-with-k-set-bits/">2859. Sum of Values at Indices With K Set Bits</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution338
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2917
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY},
        difficulty = Difficulty.EASY
)
public class Solution2859 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int n = nums.size(), sum = 0;
        for (int i = (1 << k) - 1; i < n; i++) {
            if (Integer.bitCount(i) == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }

    @Complexity(time = "O(C(log(max),k))", space = "O(1)")
    public int sumIndicesWithKSetBits_2(List<Integer> nums, int k) {
        if (k == 0) {
            return nums.getFirst();
        }
        int n = nums.size(), sum = 0;
        for (int i = (1 << k) - 1; i < n; ) {
            sum += nums.get(i);
            int c = i & -i;
            int r = i + c;
            i = (((i ^ r) / c) >> 2) | r;
        }
        return sum;
    }
}