package cn.kingen.oj.leetcode.problem.p1300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts/">1371. Find the Longest Substring Containing Vowels in Even Counts</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.HASH_TABLE, Tag.STRING, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM
)
public class Solution1371 {

    @Complexity(time = "O(n)", space = "O(C)", note = "C is count of all states, 32 in this case")
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] indices = new int[1 << 5];
        Arrays.fill(indices, -1);
        indices[0] = 0;
        int ans = 0;
        for (int i = 0, state = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'a' -> state ^= 1;
                case 'e' -> state ^= 2;
                case 'i' -> state ^= 4;
                case 'o' -> state ^= 8;
                case 'u' -> state ^= 16;
            }
            if (indices[state] >= 0) {
                ans = Math.max(ans, i + 1 - indices[state]);
            } else {
                indices[state] = i + 1;
            }
        }
        return ans;
    }
}