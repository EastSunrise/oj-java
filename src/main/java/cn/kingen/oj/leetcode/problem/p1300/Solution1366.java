package cn.kingen.oj.leetcode.problem.p1300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/rank-teams-by-votes/">1366. Rank Teams by Votes</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p900.TopVotedCandidate

 */
@Question(
    tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING, Tag.SORTING},
    difficulty = Difficulty.MEDIUM
)
public class Solution1366 {

    @Complexity(time = "O(m*n+C*log(C)*m)", space = "O(C*m)", note = "C is 26")
    public String rankTeams(String[] votes) {
        int m = votes[0].length();
        int[][] ranks = new int[26][m + 1];
        for (String vote : votes) {
            for (int j = 0; j < m; j++) {
                int ch = vote.charAt(j);
                ranks[ch - 'A'][j]++;
                ranks[ch - 'A'][m] = 0xff - ch;
            }
        }
        Arrays.sort(ranks, Arrays::compare);
        StringBuilder ans = new StringBuilder();
        for (int i = 25; i >= 0 && ranks[i][m] != 0; i--) {
            ans.append((char) (0xff - ranks[i][m]));
        }
        return ans.toString();
    }
}