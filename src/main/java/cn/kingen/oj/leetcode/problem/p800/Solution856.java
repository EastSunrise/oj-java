package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/score-of-parentheses/">856. Score of Parentheses</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STACK, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution856 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int scoreOfParentheses(String s) {
        int n = s.length();
        // positive values mean the scores and -1 means the left parenthesis
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(-1);
            } else {
                int score = stack.pop();
                if (score == -1) { // a pair of parentheses
                    stack.push(1);
                } else { // find the left parenthesis
                    while (!stack.isEmpty() && stack.peek() != -1) {
                        score += stack.pop();
                    }
                    stack.pop(); // pop the left parenthesis
                    stack.push(2 * score);
                }
            }
        }
        int score = 0;
        while (!stack.isEmpty()) {
            score += stack.pop();
        }
        return score;
    }

    @Complexity(time = "O(n)", space = "O(1)")
    public int scoreOfParentheses2(String s) {
        int n = s.length();
        int depth = 0, score = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                if (s.charAt(i - 1) == '(') { // only the pair of adjacent parentheses scores based on its depth
                    score += 1 << depth;
                }
            }
        }
        return score;
    }
}