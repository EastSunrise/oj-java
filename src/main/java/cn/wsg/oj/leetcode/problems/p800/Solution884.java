package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashSet;
import java.util.Set;

/**
 * 884. Uncommon Words from Two Sentences (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/">Uncommon Words
 * from Two Sentences</a>
 */
public class Solution884 implements Solution {

    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> unique = new HashSet<>(), duplicate = new HashSet<>();
        for (String s : s1.split(" ")) {
            if (!unique.add(s)) {
                duplicate.add(s);
            }
        }
        for (String s : s2.split(" ")) {
            if (!unique.add(s)) {
                duplicate.add(s);
            }
        }
        unique.removeAll(duplicate);
        return unique.toArray(new String[0]);
    }
}
