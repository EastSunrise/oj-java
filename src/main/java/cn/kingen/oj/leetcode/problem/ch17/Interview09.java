package cn.kingen.oj.leetcode.problem.ch17;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/get-kth-magic-number-lcci/">面试题 17.09. Get Kth Magic Number LCCI</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution264
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.MATH, Tag.DYNAMIC_PROGRAMMING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Interview09 {

    @Complexity(time = "O(k)", space = "O(k)")
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int p3 = 0, p5 = 0, p7 = 0;
        for (int i = 1; i < k; i++) {
            int a = dp[p3] * 3, b = dp[p5] * 5, c = dp[p7] * 7;
            int min = Math.min(a, Math.min(b, c));
            dp[i] = min;
            if (min == a) {
                p3++;
            }
            if (min == b) {
                p5++;
            }
            if (min == c) {
                p7++;
            }
        }
        return dp[k - 1];
    }
}