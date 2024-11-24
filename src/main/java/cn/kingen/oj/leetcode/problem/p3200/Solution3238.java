package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-number-of-winning-players/">3238. Find the Number of Winning Players</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution464
 * @see cn.kingen.oj.leetcode.problem.p400.Solution486

 */
@Question(
    tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.COUNTING},
    difficulty = Difficulty.EASY
)
public class Solution3238 {

    @Complexity(time = "O(mn)", space = "O(mn)")
    public int winningPlayerCount(int n, int[][] pick) {
        int m = 11;
        int[][] count = new int[n + 1][m];
        for (int[] p : pick) {
            count[p[0]][p[1]]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int c : count[i]) {
                if (c > i) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}