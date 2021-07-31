package wsg.oj.java.leetcode.problems.p800;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 893. Groups of Special-Equivalent Strings (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/groups-of-special-equivalent-strings/">Groups of
 * Special-Equivalent Strings</a>
 * @since 2021-07-27
 */
public class Solution893 implements Solution {

    /**
     * @complexity T=O(n*m*log{m}), n=the number of words, m=the length of a word
     * @complexity S=O(mn)
     */
    public int numSpecialEquivGroups(String[] words) {
        Set<String> group = new HashSet<>();
        for (String word : words) {
            char[] even = new char[(word.length() + 1) / 2];
            for (int i = 0; i < word.length(); i += 2) {
                even[i / 2] = word.charAt(i);
            }
            char[] odd = new char[word.length() / 2];
            for (int i = 1; i < word.length(); i += 2) {
                odd[i / 2] = word.charAt(i);
            }
            Arrays.sort(even);
            Arrays.sort(odd);
            group.add(new String(even) + new String(odd));
        }
        return group.size();
    }
}
