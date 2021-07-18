package wsg.oj.java.leetcode.problems.p0;

import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 32. Longest Valid Parentheses (HARD)
 *
 * @author Kingen
 * @see Solution20
 * @see <a href="https://leetcode-cn.com/problems/longest-valid-parentheses/">Longest Valid
 * Parentheses</a>
 * @since 2021-07-17
 */
class Solution32 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> lefts = new Stack<>();
        // store the last unmatched index
        lefts.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lefts.push(i);
            } else {
                lefts.pop();
                if (lefts.isEmpty()) {
                    // not valid
                    lefts.push(i);
                } else {
                    max = Math.max(max, i - lefts.peek());
                }
            }
        }
        return max;
    }
}
