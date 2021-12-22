package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 926. Flip String to Monotone Increasing (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/">Flip String
 * to Monotone Increasing</a>
 */
public class Solution926 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
