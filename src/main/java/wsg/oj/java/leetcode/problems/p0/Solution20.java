package wsg.oj.java.leetcode.problems.p0;

import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 20. Valid Parentheses (Easy)
 *
 * @author Kingen
 * @see Solution22
 * @see Solution32
 * @see Solution301
 * @see Solution1003
 * @see <a href="https://leetcode-cn.com/problems/valid-parentheses/">Valid Parentheses</a>
 * @since 2021-07-10
 */
class Solution20 implements Solution {

    /**
     * Uses stack to pair up parentheses.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if ('(' == ch || '[' == ch || '{' == ch) {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            int match = ch - stack.pop();
            if (match == 1 || match == 2) {
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }
}
