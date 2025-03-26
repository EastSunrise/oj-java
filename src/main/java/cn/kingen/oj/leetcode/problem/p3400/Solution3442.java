package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-difference-between-even-and-odd-frequency-i/">3442. Maximum Difference Between Even and Odd Frequency I</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING},
        difficulty = Difficulty.EASY,
        contest = 435
)
public class Solution3442 {

    @Complexity(time = "O(n+C)", space = "O(C)", note = "C is 26")
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int odd = 0, even = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            if (freq[i] % 2 == 0) {
                even = Math.min(even, freq[i]);
            } else {
                odd = Math.max(odd, freq[i]);
            }
        }
        return odd - even;
    }
}