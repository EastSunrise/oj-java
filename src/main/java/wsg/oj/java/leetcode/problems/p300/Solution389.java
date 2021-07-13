package wsg.oj.java.leetcode.problems.p300;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution136;

/**
 * 389. Find the Difference (Easy)
 *
 * @author Kingen
 * @see Solution136
 * @see <a href="https://leetcode-cn.com/problems/find-the-difference/">Find the Difference</a>
 * @since 2021-07-13
 */
class Solution389 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public char findTheDifference(String s, String t) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum ^= c;
        }
        for (char c : t.toCharArray()) {
            sum ^= c;
        }
        return (char) sum;
    }
}
