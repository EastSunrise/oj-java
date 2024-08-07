package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

import static cn.kingen.oj.leetcode.util.MathUtils.applyOperator;

/**
 * <a href="https://leetcode.cn/problems/different-ways-to-add-parentheses/">241. Different Ways to Add Parentheses</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution95
 * @see cn.kingen.oj.leetcode.problem.p200.Solution224
 * @see cn.kingen.oj.leetcode.problem.p200.Solution282
 */
@Question(tags = {Tag.RECURSION, Tag.MEMOIZATION, Tag.MATH, Tag.STRING, Tag.DYNAMIC_PROGRAMMING}, difficulty = Difficulty.MEDIUM)
public class Solution241 {

    @Complexity(time = "O(G(n))", space = "O(G(n))", note = "n is count of operators and G(n) is Catalan number")
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> operands = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c < '0' || '9' < c) {
                operands.add(num);
                operators.add(c);
                num = 0;
            } else {
                num = num * 10 + c - '0';
            }
        }
        operands.add(num);

        int n = operands.size();
        List<List<List<Integer>>> memo = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            memo.add(new ArrayList<>(n));
            for (int j = 0; j < n; j++) {
                memo.get(i).add(null);
            }
        }
        return dfs(memo, operators, operands, 0, operands.size() - 1);
    }

    private List<Integer> dfs(List<List<List<Integer>>> memo, List<Character> operators, List<Integer> operands, int from, int to) {
        if (memo.get(from).get(to) != null) {
            return memo.get(from).get(to);
        }
        List<Integer> ans = new ArrayList<>();
        if (from == to) {
            ans.add(operands.get(from));
        } else {
            for (int i = from; i < to; i++) {
                List<Integer> left = dfs(memo, operators, operands, from, i);
                List<Integer> right = dfs(memo, operators, operands, i + 1, to);
                char operator = operators.get(i);
                for (int operand1 : left) {
                    for (int operand2 : right) {
                        ans.add(applyOperator(operator, operand1, operand2));
                    }
                }
            }
        }
        memo.get(from).set(to, ans);
        return ans;
    }
}