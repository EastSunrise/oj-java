package cn.kingen.oj.leetcode.problem.p100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.StringUtils.isAlphanumeric;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome/">125. Valid Palindrome</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution234
 * @see cn.kingen.oj.leetcode.problem.p600.Solution680
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2002
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2108
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2330
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3035
 */
@Question(
        tags = {Tag.TWO_POINTERS, Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution125 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ) {
            char ci = s.charAt(i), cj = s.charAt(j);
            if (!isAlphanumeric(ci)) {
                i++;
            } else if (!isAlphanumeric(cj)) {
                j--;
            } else {
                if (Character.toLowerCase(ci) == Character.toLowerCase(cj)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}