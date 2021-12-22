package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Stack;

/**
 * 331. Verify Preorder Serialization of a Binary Tree (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/">Verify
 * Preorder Serialization of a Binary Tree</a>
 */
public class Solution331 implements Solution {

    /**
     * @see #PREORDER
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_H
     */
    public boolean isValidSerialization(String preorder) {
        int len = preorder.length();
        boolean left = true;
        int i = 0;
        // record that current node is the left node or right one
        Stack<Boolean> stack = new Stack<>();
        while (i < len) {
            char ch = preorder.charAt(i);
            if (ch == '#') {
                if (!left) {
                    // backtracking to the closest left node
                    while (!stack.isEmpty() && !stack.peek()) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
                // finish a left node
                left = false;
                i += 2;
            } else {
                stack.push(left);
                // start its left node
                left = true;
                do {
                    i++;
                } while (i < len && preorder.charAt(i) != ',');
                i++;
            }
        }
        return stack.isEmpty();
    }
}
