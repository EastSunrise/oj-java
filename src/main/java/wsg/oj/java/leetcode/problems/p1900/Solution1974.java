package wsg.oj.java.leetcode.problems.p1900;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1974. Minimum Time to Type Word Using Special Typewriter (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minimum-time-to-type-word-using-special-typewriter/">Minimum
 * Time to Type Word Using Special Typewriter</a>
 * @since 2021-08-28
 */
public class Solution1974 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int minTimeToType(String word) {
        int seconds = word.length();
        char prev = 'a';
        for (char ch : word.toCharArray()) {
            int dif = Math.abs(ch - prev);
            seconds += Math.min(dif, 26 - dif);
            prev = ch;
        }
        return seconds;
    }
}
