package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/">438. Find All Anagrams in a String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution242
 * @see cn.kingen.oj.leetcode.problem.p500.Solution567
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution438 {

    @Complexity(time = "O(m+n+C)", space = "O(C)", note = "C is the number of distinct characters")
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        if (m < n) {
            return new ArrayList<>();
        }
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[p.charAt(i) - 'a']++;
        }
        int[] window = new int[26];
        for (int i = 0; i < n; i++) {
            window[s.charAt(i) - 'a']++;
        }

        int base = hash(counts);
        int hash = hash(window);
        List<Integer> ans = new ArrayList<>();
        for (int i = n; ; i++) {
            if (hash == base && Arrays.equals(counts, window)) {
                ans.add(i - n);
            }
            if (i == m) {
                break;
            }
            int first = s.charAt(i - n) - 'a', last = s.charAt(i) - 'a';
            hash = hash + last - first;
            window[first]--;
            window[last]++;
        }
        return ans;
    }

    private int hash(int[] counts) {
        int hash = 0;
        for (int i = 0; i < 26; i++) {
            hash += i * counts[i];
        }
        return hash;
    }
}