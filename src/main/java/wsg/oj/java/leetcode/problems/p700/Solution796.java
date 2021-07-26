package wsg.oj.java.leetcode.problems.p700;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 796. Rotate String (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/rotate-string/">Rotate String</a>
 * @since 2021-07-26
 */
class Solution796 implements Solution {

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (goal + goal).contains(s);
    }
}
