package wsg.oj.java.leetcode.problems.interview.ch1;

import java.util.Map;
import wsg.oj.java.leetcode.problems.base.StringSolution;

/**
 * 面试题 1.2. Check Permutation LCCI (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/check-permutation-lcci/">Check Permutation
 * LCCI</a>
 * @since 2021-07-28
 */
public class Interview2 implements StringSolution {

    /**
     * @complexity T=O(m+n+L), L=the size of the character set
     * @complexity S=O(L)
     */
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> counts1 = stat(s1);
        Map<Character, Integer> counts2 = stat(s2);
        for (Map.Entry<Character, Integer> entry : counts1.entrySet()) {
            if (!entry.getValue().equals(counts2.getOrDefault(entry.getKey(), 0))) {
                return false;
            }
        }
        return true;
    }
}
