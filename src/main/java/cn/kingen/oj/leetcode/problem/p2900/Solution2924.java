package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-champion-ii/">2924. Find Champion II</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GRAPH},
        difficulty = Difficulty.MEDIUM
)
public class Solution2924 {

    @Complexity(time = "O(n+E)", space = "O(n)", note = "E is the number of edges")
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (ans != -1) {
                    return -1;
                }
                ans = i;
            }
        }
        return ans;
    }
}