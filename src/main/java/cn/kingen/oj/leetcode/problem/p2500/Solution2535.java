package cn.kingen.oj.leetcode.problem.p2500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/difference-between-element-sum-and-digit-sum-of-an-array/">2535. Difference Between Element Sum and Digit Sum of an Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution258
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2160
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH},
        difficulty = Difficulty.EASY
)
public class Solution2535 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int differenceOfSum(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans += num;
            while (num > 0) {
                ans -= num % 10;
                num /= 10;
            }
        }
        return ans;
    }
}