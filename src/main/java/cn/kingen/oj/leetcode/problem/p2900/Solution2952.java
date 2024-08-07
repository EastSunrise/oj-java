package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-coins-to-be-added/">2952. Minimum Number of Coins to be Added</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution322
 * @see cn.kingen.oj.leetcode.problem.p2900.Solution2979
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2952 {

    @Complexity(time = "O(n*log{n} + log{target})", space = "O(log{n})")
    public int minimumAddedCoins(int[] coins, int target) {
        int n = coins.length;
        Arrays.sort(coins);
        // max: maximum available by coins[0,i-1]
        int max = 0, ans = 0, i = 0;
        while (max < target) {
            if (i < n && coins[i] <= max + 1) {
                max += coins[i];
                i++;
            } else { // add a coin (max+1)
                max += max + 1;
                ans++;
            }
        }
        return ans;
    }
}