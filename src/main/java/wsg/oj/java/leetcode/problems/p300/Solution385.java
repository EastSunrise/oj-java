package wsg.oj.java.leetcode.problems.p300;

import java.util.List;
import java.util.Stack;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 385. Mini Parser (Medium)
 *
 * @author Kingen
 * @see Solution341
 * @see Solution439
 * @see Solution722
 * @see <a href="https://leetcode-cn.com/problems/mini-parser/">Mini Parser</a>
 * @since 2021-07-06
 */
public class Solution385 implements Solution {

    /**
     * Uses a stack to stores outer {@link NestedInteger}.
     *
     * @complexity T=O(n)
     * @complexity S=O(h), h=the nested levels
     */
    public NestedInteger deserialize(String s) {
        StringBuilder digits = new StringBuilder();
        Stack<NestedInteger> stack = new Stack<>();
        stack.push(new NestedInteger());
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '[':
                    stack.push(new NestedInteger());
                    break;
                case ']':
                    if (digits.length() > 0) {
                        stack.peek().add(new NestedInteger(Integer.parseInt(digits.toString())));
                        digits = new StringBuilder();
                    }
                    NestedInteger top = stack.pop();
                    stack.peek().add(top);
                    break;
                case ',':
                    if (digits.length() > 0) {
                        stack.peek().add(new NestedInteger(Integer.parseInt(digits.toString())));
                        digits = new StringBuilder();
                    }
                    break;
                default:
                    digits.append(ch);
            }
        }
        if (digits.length() > 0) {
            stack.peek().add(new NestedInteger(Integer.parseInt(digits.toString())));
        }
        return stack.pop().getList().get(0);
    }

    /**
     * This is the interface that allows for creating nested lists.
     */
    public static class NestedInteger {

        /**
         * Constructor initializes an empty nested list.
         */
        public NestedInteger() {
        }

        /**
         * Constructor initializes a single integer.
         */
        public NestedInteger(int value) {
        }

        /**
         * @return true if this NestedInteger holds a single integer, rather than a nested list.
         */
        public boolean isInteger() {
            return false;
        }

        /**
         * @return the single integer that this NestedInteger holds, if it holds a single integer
         * Return null if this NestedInteger holds a nested list
         */
        public Integer getInteger() {
            return null;
        }

        /**
         * Set this NestedInteger to hold a nested list and adds a nested integer to it.
         */
        public void add(NestedInteger ni) {

        }

        /**
         * @return the nested list that this NestedInteger holds, if it holds a nested list Return
         * empty list if this NestedInteger holds a single integer
         */
        public List<NestedInteger> getList() {
            return null;
        }
    }
}
