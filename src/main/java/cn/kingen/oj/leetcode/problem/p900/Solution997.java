package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-town-judge/">997. Find the Town Judge</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution277

 */
@Question(
    tags = {Tag.GRAPH, Tag.ARRAY, Tag.HASH_TABLE},
    difficulty = Difficulty.EASY
)
public class Solution997 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n + 1];
        int[] trusted = new int[n + 1];
        for (int[] entry : trust) {
            trusts[entry[0]]++;
            trusted[entry[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trusts[i] == 0) {
                return trusted[i] + 1 == n ? i : -1;
            }
        }
        return -1;
    }
}