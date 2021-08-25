package wsg.oj.java.leetcode.problems.p1200;

import java.util.Deque;
import java.util.LinkedList;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1249. Minimum Remove to Make Valid Parentheses (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses/">Minimum
 * Remove to Make Valid Parentheses</a>
 * @since 2021-07-27
 */
public class Solution1249 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Deque<Integer> lefts = new LinkedList<>();
        boolean[] deleted = new boolean[n];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                lefts.push(i);
            } else if (ch == ')') {
                if (lefts.isEmpty()) {
                    deleted[i] = true;
                } else {
                    lefts.pop();
                }
            }
        }
        while (!lefts.isEmpty()) {
            deleted[lefts.pop()] = true;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!deleted[i]) {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
