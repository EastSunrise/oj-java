package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-number-of-texts/">2266. Count Number of Texts</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution17
 * @see cn.kingen.oj.leetcode.problem.p0.Solution91
 */
@Question(
    tags = {Tag.HASH_TABLE, Tag.MATH, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
    difficulty = Difficulty.MEDIUM
)
public class Solution2266 {

    private static final int[] DICT = new int[]{0, 0, 3, 3, 3, 3, 3, 4, 3, 4};

    @Complexity(time = "O(n)", space = "O(n)")
    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            char ch = pressedKeys.charAt(i);
            int min = Math.max(0, i - DICT[ch - '0'] + 1);
            for (int j = i; j >= min && pressedKeys.charAt(j) == ch; j--) {
                dp[i + 1] = (dp[i + 1] + dp[j]) % 1000000007;
            }
        }
        return dp[n];
    }
}