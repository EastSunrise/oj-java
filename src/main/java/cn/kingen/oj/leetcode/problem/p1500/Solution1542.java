package cn.kingen.oj.leetcode.problem.p1500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-longest-awesome-substring/">1542. Find Longest Awesome Substring</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.HASH_TABLE, Tag.STRING},
        difficulty = Difficulty.HARD
)
public class Solution1542 {

    @Complexity(time = "O(n*k)", space = "O(2^k)", note = "k is the number of distinct characters")
    public int longestAwesome(String s) {
        int n = s.length(), k = 10, size = 1 << k;
        int[] indices = new int[size];
        Arrays.fill(indices, -1);
        indices[0] = 0;
        int ans = 0;
        for (int i = 0, state = 0; i < n; i++) {
            state ^= 1 << (s.charAt(i) - '0');
            for (int j = 1; j < size; j <<= 1) {
                int t = state ^ j;
                if (indices[t] != -1) {
                    ans = Math.max(ans, i + 1 - indices[t]);
                }
            }
            if (indices[state] != -1) {
                ans = Math.max(ans, i + 1 - indices[state]);
            } else {
                indices[state] = i + 1;
            }
        }
        return ans;
    }
}