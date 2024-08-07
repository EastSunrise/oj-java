package cn.kingen.oj.leetcode.problem.p1900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/number-of-wonderful-substrings/">1915. Number of Wonderful Substrings</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.HASH_TABLE, Tag.STRING, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM
)
public class Solution1915 {

    @Complexity(time = "O(nk)", space = "O(2^k)", note = "k is the number of distinct characters")
    public long wonderfulSubstrings(String word) {
        int n = word.length(), k = 10, size = 1 << k;
        int[] counts = new int[size];
        counts[0] = 1;
        long ans = 0;
        for (int i = 0, state = 0; i < n; i++) {
            state ^= 1 << (word.charAt(i) - 'a');
            ans += counts[state];
            for (int j = 1; j < size; j <<= 1) {
                ans += counts[state ^ j];
            }
            counts[state]++;
        }
        return ans;
    }
}