package wsg.oj.java.leetcode.problems.p300;

import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 316. Remove Duplicate Letters (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicate-letters/">Remove Duplicate
 * Letters</a>
 * @since 2021-07-13
 */
class Solution316 implements Solution {

    /**
     * Uses a stack to store the chars in lexicographical order.
     *
     * @complexity S=O(26)
     * @see wsg.oj.java.Complexity#TIME_N
     */
    public String removeDuplicateLetters(String s) {
        // store the result in lexicographical order
        Stack<Character> stack = new Stack<>();
        // whether the char is chosen already
        boolean[] chosen = new boolean[26];
        // remaining chars
        int[] remaining = new int[26];
        for (char ch : s.toCharArray()) {
            remaining[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            remaining[idx]--;
            if (chosen[idx]) {
                // since the stack is increasing except the distinct ones
                // ignore this one of the duplicate character
                continue;
            }
            // think of the top char x0 of the stack
            // if there is another x1(x0=x1) after c (the sequences is x0~c~x1),
            // one of x0 and x1 should be removed:
            // if x0>c, remove x0 since x0~c > c~x1
            while (!stack.isEmpty() && remaining[stack.peek() - 'a'] > 0 && stack.peek() > c) {
                chosen[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            chosen[idx] = true;
        }
        StringBuilder builder = new StringBuilder(stack.size());
        for (char ch : stack) {
            builder.append(ch);
        }
        return builder.toString();
    }
}
