package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/permutation-in-string/">567. Permutation in String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution76
 * @see cn.kingen.oj.leetcode.problem.p400.Solution438
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.TWO_POINTERS, Tag.STRING, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution567 {

    @Complexity(time = "O(m+n+C)", space = "O(C)", note = "C is the number of distinct characters")
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < m; i++) {
            counts[s1.charAt(i) - 'a']++;
        }
        int[] window = new int[26];
        for (int i = 0; i < m; i++) {
            window[s2.charAt(i) - 'a']++;
        }

        int base = hash(counts);
        int hash = hash(window);
        for (int i = m; ; i++) {
            if (hash == base && Arrays.equals(counts, window)) {
                return true;
            }
            if (i == n) {
                return false;
            }
            int first = s2.charAt(i - m) - 'a', last = s2.charAt(i) - 'a';
            hash = hash + last - first;
            window[first]--;
            window[last]++;
        }
    }

    private int hash(int[] counts) {
        int hash = 0;
        for (int i = 0; i < 26; i++) {
            hash += i * counts[i];
        }
        return hash;
    }
}