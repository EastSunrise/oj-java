package cn.kingen.oj.leetcode.problem.p0;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams/">49. Group Anagrams</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution242
 * @see cn.kingen.oj.leetcode.problem.p200.Solution249
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution49 {

    @Complexity(time = "O(n*L)", space = "O(n*k)", note = "n is the number of strings, L is the average length of strings")
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Stat, List<String>> groups = new HashMap<>(16);
        for (String str : strs) {
            int[] freq = new int[26];
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }
            groups.computeIfAbsent(new Stat(freq), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(groups.values());
    }

    private record Stat(int[] freq) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Stat stat = (Stat) o;
            return Arrays.equals(freq, stat.freq);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(freq);
        }
    }
}