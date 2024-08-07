package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/special-array-i/">3151. Special Array I</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY},
        difficulty = Difficulty.EASY
)
public class Solution3151 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length, r = nums[0] & 1;
        for (int i = 1; i < n; i++) {
            if ((nums[i] & 1) == r) {
                return false;
            }
            r ^= 1;
        }
        return true;
    }
}