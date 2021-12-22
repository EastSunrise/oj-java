package cn.wsg.oj.leetcode.problems.p1600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 1626. Best Team With No Conflicts (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/best-team-with-no-conflicts/">Best Team With No
 * Conflicts</a>
 */
public class Solution1626 implements Solution {

    /**
     * @see Complexity#TIME_NN
     * @see Complexity#SPACE_N
     */
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] players = new int[n][];
        for (int i = 0; i < n; i++) {
            players[i] = new int[]{ages[i], scores[i]};
        }
        Arrays.sort(players,
            Comparator.<int[], Integer>comparing(a -> a[0]).thenComparing(a -> a[1]));

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = players[i][1];
            for (int j = 0; j < i; j++) {
                if (players[j][1] <= players[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + players[i][1]);
                }
            }
        }
        return Arrays.stream(dp).max().orElseThrow();
    }
}
