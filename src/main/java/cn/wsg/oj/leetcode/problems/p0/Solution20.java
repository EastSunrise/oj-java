package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. Valid Parentheses (Easy)
 *
 * @author Kingen
 * @see Solution22
 * @see Solution32
 * @see Solution301
 * @see Solution1003
 * @see <a href="https://leetcode-cn.com/problems/valid-parentheses/">Valid Parentheses</a>
 */
public class Solution20 implements Solution {

    /**
     * Uses stack to pair up parentheses.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
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
