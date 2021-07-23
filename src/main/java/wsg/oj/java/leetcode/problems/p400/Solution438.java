package wsg.oj.java.leetcode.problems.p400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution242;
import wsg.oj.java.leetcode.problems.p500.Solution567;

/**
 * 438. Find All Anagrams in a String (Medium)
 *
 * @author Kingen
 * @see Solution242
 * @see Solution567
 * @see <a href="https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/">Find All Anagrams
 * in a String</a>
 * @since 2021-07-07
 */
public class Solution438 implements Solution {

    /**
     * Keeps a window of the same length of p.
     *
     * @complexity T=O(26*n)
     * @complexity S=O(26)
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int pLen = p.length(), sLen = s.length();
        if (sLen < pLen) {
            return res;
        }
        int[] pCounts = new int[26];
        for (char ch : p.toCharArray()) {
            pCounts[ch - 'a']++;
        }
        int[] sCounts = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCounts[s.charAt(i) - 'a']++;
        }
        int index = 0;
        while (true) {
            if (Arrays.equals(pCounts, sCounts)) {
                res.add(index);
            }
            if (index + pLen >= s.length()) {
                break;
            }
            sCounts[s.charAt(index) - 'a']--;
            sCounts[s.charAt(index + pLen) - 'a']++;
            index++;
        }
        return res;
    }
}
