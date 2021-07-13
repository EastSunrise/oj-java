package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution242;

/**
 * 49. Group Anagrams (Medium)
 *
 * @author Kingen
 * @see Solution242
 * @see Solution249
 * @see <a href="https://leetcode-cn.com/problems/group-anagrams/">Group Anagrams</a>
 * @since 2021-07-11
 */
public class Solution49 implements Solution {

    /**
     * Uses the frequency of characters of a string as its hash and then group them.
     *
     * @complexity T=O(L), L=sum(len(str))
     * @complexity S=O(cn), c=26, count of unique characters
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Stat, List<String>> groups = new HashMap<>(16);
        for (String str : strs) {
            int[] values = new int[26];
            for (char ch : str.toCharArray()) {
                values[ch - 'a']++;
            }
            Stat stat = new Stat(values);
            if (groups.containsKey(stat)) {
                groups.get(stat).add(str);
            } else {
                List<String> group = new ArrayList<>();
                group.add(str);
                groups.put(stat, group);
            }
        }
        return new ArrayList<>(groups.values());
    }

    private static class Stat {

        private final int[] values;

        private Stat(int[] values) {
            this.values = values;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Stat stat = (Stat) o;
            return Arrays.equals(values, stat.values);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(values);
        }
    }
}
