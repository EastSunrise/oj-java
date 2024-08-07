package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.*;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/mini-parser/">385. Mini Parser</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.NestedIterator
 * @see cn.kingen.oj.leetcode.problem.p400.Solution439
 * @see cn.kingen.oj.leetcode.problem.p700.Solution722
 */
@Question(
        tags = {Tag.STACK, Tag.DEPTH_FIRST_SEARCH, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution385 {

    @Complexity(time = "O(n)", space = "O(n)")
    public NestedInteger deserialize(String s) {
        Deque<NestedInteger> stack = new ArrayDeque<>();
        stack.push(new NestedInteger());
        // sign: 1 for positive, -1 for negative, 0 for no number
        int sign = 0, number = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '[') { // start a new nested list
                stack.push(new NestedInteger());
            } else if (ch == ']') { // end of current nested list
                if (sign != 0) {
                    stack.element().add(new NestedInteger(sign * number));
                    sign = 0;
                    number = 0;
                }
                NestedInteger current = stack.pop();
                stack.element().add(current);
            } else if (ch == ',') { // end of a number
                if (sign != 0) {
                    stack.element().add(new NestedInteger(sign * number));
                    sign = 0;
                    number = 0;
                }
            } else { // number
                if (sign == 0) {
                    sign = ch == '-' ? -1 : 1;
                    number = ch == '-' ? 0 : ch - '0';
                } else {
                    number = number * 10 + ch - '0';
                }
            }
        }
        if (sign != 0) {
            stack.element().add(new NestedInteger(sign * number));
        }
        return stack.pop().getList().getFirst();
    }
}