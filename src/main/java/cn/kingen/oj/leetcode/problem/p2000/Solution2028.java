package cn.kingen.oj.leetcode.problem.p2000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-missing-observations/">2028. Find Missing Observations</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution2028 {

    @Complexity(time = "O(m+n)", space = "O(1)")
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = mean * (rolls.length + n);
        for (int roll : rolls) {
            sum -= roll;
        }
        if (sum < n || sum > 6 * n) {
            return new int[0];
        }
        sum -= n;
        int count6 = sum / 5;
        int[] ans = new int[n];
        Arrays.fill(ans, 0, count6, 6);
        Arrays.fill(ans, count6, n, 1);
        if (count6 < n) {
            ans[n - 1] = 1 + sum % 5;
        }
        return ans;
    }
}