package cn.wsg.oj.leetcode.problems.p1900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1974. Minimum Time to Type Word Using Special Typewriter (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minimum-time-to-type-word-using-special-typewriter/">Minimum
 * Time to Type Word Using Special Typewriter</a>
 */
public class Solution1974 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
