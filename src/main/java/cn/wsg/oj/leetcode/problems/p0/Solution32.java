package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. Longest Valid Parentheses (HARD)
 *
 * @author Kingen
 * @see Solution20
 * @see <a href="https://leetcode-cn.com/problems/longest-valid-parentheses/">Longest Valid
 * Parentheses</a>
 */
public class Solution32 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        Deque<Integer> lefts = new LinkedList<>();
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
