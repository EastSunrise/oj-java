package wsg.oj.java.leetcode.problems.p0;

import java.util.Deque;
import java.util.LinkedList;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 71. Simplify Path (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/simplify-path/">Simplify Path</a>
 * @since 2021-07-11
 */
public class Solution71 implements Solution {

    /**
     * Uses a stack to return back.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder temp = new StringBuilder();
        for (char ch : (path + "/").toCharArray()) {
            if (ch == '/') {
                if (temp.length() > 0) {
                    String name = temp.toString();
                    if ("..".equals(name)) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    } else if (!".".equals(name)) {
                        stack.push(name);
                    }
                    temp = new StringBuilder();
                }
            } else {
                temp.append(ch);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        for (String s : stack) {
            res.append("/").append(s);
        }
        return res.toString();
    }
}
