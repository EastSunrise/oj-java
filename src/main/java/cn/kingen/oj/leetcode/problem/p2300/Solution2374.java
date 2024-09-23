package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/node-with-highest-edge-score/">2374. Node With Highest Edge Score</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution1
 * @see cn.kingen.oj.leetcode.problem.p400.Solution451
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1636

 */
@Question(
    tags = {Tag.GRAPH, Tag.HASH_TABLE},
    difficulty = Difficulty.MEDIUM
)
public class Solution2374 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] scores = new long[n];
        for (int i = 0; i < n; i++) {
            scores[edges[i]] += i;
        }
        long max = Long.MIN_VALUE;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (scores[i] > max) {
                max = scores[i];
                ans = i;
            }
        }
        return ans;
    }
}