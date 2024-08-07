package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/valid-parenthesis-string/">678. Valid Parenthesis String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p700.Solution761
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2116
 */
@Question(
        tags = {Tag.STACK, Tag.GREEDY, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution678 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean checkValidString(String s) {
        int n = s.length();
        int lefts = 0, stars = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                lefts++;
            } else if (ch == '*') {
                stars++;
            } else if (lefts > 0) { // a pair of "(" and ")"
                lefts--;
            } else if (stars > 0) { // regard "*" as "("
                stars--;
            } else {
                return false;
            }
        }
        int rights = stars = 0;
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ')') {
                rights++;
            } else if (ch == '*') {
                stars++;
            } else if (rights > 0) { // a pair of ")" and "("
                rights--;
            } else if (stars > 0) { // regard "*" as ")"
                stars--;
            } else {
                return false;
            }
        }
        return true;
    }
}