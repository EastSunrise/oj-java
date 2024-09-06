package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-strength-of-a-group/">2708. Maximum Strength of a Group</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3077
 */
@Question(tags = {Tag.GREEDY, Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING, Tag.BACKTRACKING, Tag.ENUMERATION, Tag.SORTING}, difficulty = Difficulty.MEDIUM)
public class Solution2708 {

    @Complexity(time = "O(n)", space = "O(1)")
    public long maxStrength(int[] nums) {
        long product = 1;
        int positiveCnt = 0, negativeCnt = 0, maxNegative = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > 0) {
                product *= num;
                positiveCnt++;
            } else if (num < 0) {
                product *= num;
                negativeCnt++;
                maxNegative = Math.max(maxNegative, num);
            }
        }
        if (positiveCnt > 0 || negativeCnt >= 2) {
            return product > 0 ? product : product / maxNegative;
        }
        return negativeCnt < nums.length ? 0 : product;
    }
}