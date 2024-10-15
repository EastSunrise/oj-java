package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/super-egg-drop/">887. Super Egg Drop</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1884

 */
@Question(
    tags = {Tag.MATH, Tag.BINARY_SEARCH, Tag.DYNAMIC_PROGRAMMING},
    difficulty = Difficulty.HARD
)
public class Solution887 {

    @Complexity(time = "#", space = "O(k)")
    public int superEggDrop(int k, int n) {
        int[] dp = new int[k + 1];
        for (int i = 1; ; i++) {
            for (int j = k; j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1] + 1;
                if (dp[j] >= n) {
                    return i;
                }
            }
        }
    }
}