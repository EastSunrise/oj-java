package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-points-inside-the-square/">3143. Maximum Points Inside the Square</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING, Tag.BINARY_SEARCH, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3143 {

    @Complexity(time = "O(n)", space = "O(C)", note = "C is the number of distinct characters")
    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = points.length;
        int[] dist = new int[26];
        Arrays.fill(dist, -1);
        int radius = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            int d = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            if (dist[c] == -1) {
                dist[c] = d;
            } else {
                radius = Math.min(radius, Math.max(dist[c], d));
                dist[c] = Math.min(dist[c], d);
            }
        }

        int ans = 0;
        for (int d : dist) {
            if (d != -1 && d < radius) {
                ans++;
            }
        }
        return ans;
    }
}