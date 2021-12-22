package cn.wsg.oj.leetcode.problems.p1200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 1249. Minimum Remove to Make Valid Parentheses (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses/">Minimum
 * Remove to Make Valid Parentheses</a>
 */
public class Solution1249 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
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
