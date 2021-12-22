package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution242;
import cn.wsg.oj.leetcode.problems.p500.Solution567;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String (Medium)
 *
 * @author Kingen
 * @see Solution242
 * @see Solution567
 * @see <a href="https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/">Find All Anagrams
 * in a String</a>
 */
public class Solution438 implements Solution {

    /**
     * Keeps a window of the same length of p.
     *
     * @complexity T=O(26*n)
     * @complexity S=O(26)
     */
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        if (m < n) {
            return new ArrayList<>();
        }
        int[] counts = new int[26];
        for (char ch : p.toCharArray()) {
            counts[ch - 'a']++;
        }
        int[] window = new int[26];
        int i = 0;
        while (i < n) {
            window[s.charAt(i++) - 'a']++;
        }

        int base = hash(counts);
        int hash = hash(window);
        List<Integer> res = new ArrayList<>();
        while (true) {
            if (hash == base && Arrays.equals(counts, window)) {
                res.add(i - n);
            }
            if (i == m) {
                break;
            }
            int idx = s.charAt(i) - 'a';
            hash += idx;
            window[idx]++;
            idx = s.charAt(i - n) - 'a';
            hash -= idx;
            window[idx]--;
            i++;
        }
        return res;
    }
}
