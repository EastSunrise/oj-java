package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

/**
 * <a href="https://leetcode.cn/problems/final-array-state-after-k-multiplication-operations-i/">3264. Final Array State After K Multiplication Operations I</a>
 *
 * @author Kingen
 */
@Question(
        difficulty = Difficulty.EASY
)
public class Solution3264 {

    @Complexity(time = "O(kn)", space = "O(1)")
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        while (k-- > 0) {
            int min = -1, p = -1;
            for (int i = 0; i < n; i++) {
                if (min == -1 || nums[i] < min) {
                    min = nums[i];
                    p = i;
                }
            }
            nums[p] *= multiplier;
        }
        return nums;
    }
}