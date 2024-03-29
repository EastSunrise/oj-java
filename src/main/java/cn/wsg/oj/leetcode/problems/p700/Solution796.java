package cn.wsg.oj.leetcode.problems.p700;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 796. Rotate String (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/rotate-string/">Rotate String</a>
 */
class Solution796 implements Solution {

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (goal + goal).contains(s);
    }
}
