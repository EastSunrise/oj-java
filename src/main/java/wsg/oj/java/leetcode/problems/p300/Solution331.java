package wsg.oj.java.leetcode.problems.p300;

import java.util.Stack;
import wsg.oj.java.leetcode.problems.Solution;

/**
 * 331. Verify Preorder Serialization of a Binary Tree (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/">Verify
 * Preorder Serialization of a Binary Tree</a>
 * @since 2021-07-04
 */
class Solution331 extends Solution {

    public boolean isValidSerialization(String preorder) {
        int len = preorder.length();
        boolean left = true;
        int i = 0;
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
