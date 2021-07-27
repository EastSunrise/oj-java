package wsg.oj.java.leetcode.problems.p900;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 926. Flip String to Monotone Increasing (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/">Flip String
 * to Monotone Increasing</a>
 * @since 2021-07-27
 */
public class Solution926 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int minFlipsMonoIncr(String s) {
        int flips = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                flips++;
            }
        }
        int min = flips;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                flips--;
            } else {
                flips++;
            }
            min = Math.min(min, flips);
        }
        return min;
    }
}
