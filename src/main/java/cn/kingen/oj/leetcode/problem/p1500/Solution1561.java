package cn.kingen.oj.leetcode.problem.p1500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-coins-you-can-get/">1561. Maximum Number of Coins You Can Get</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.MATH, Tag.GAME_THEORY, Tag.SORTING},
        difficulty = Difficulty.MEDIUM,
        daily = "2025-01-22"
)
public class Solution1561 {

    @Complexity(time = "O(n log n)", space = "O(1)")
    public int maxCoins(int[] piles) {
        int n = piles.length / 3;
        Arrays.sort(piles);
        int ans = 0;
        for (int i = 3 * n - 2; i >= n; i -= 2) {
            ans += piles[i];
        }
        return ans;
    }
}