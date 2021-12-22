package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 71. Simplify Path (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/simplify-path/">Simplify Path</a>
 */
public class Solution71 implements Solution {

    /**
     * Uses a stack to return back.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
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
