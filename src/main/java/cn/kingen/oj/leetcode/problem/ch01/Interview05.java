package cn.kingen.oj.leetcode.problem.ch01;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/one-away-lcci/">面试题 01.05. One Away LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.TWO_POINTERS, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Interview05 {

    @Complexity(time = "O(m+n)", space = "O(1)")
    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        int i = 0, j = 0;
        while (i < m && j < n && first.charAt(i) == second.charAt(j)) {
            i++;
            j++;
        }
        if (i == m || j == n) {
            return true;
        }
        return isEqual(first, i + 1, m, second, j, n)
                || isEqual(first, i, m, second, j + 1, n)
                || isEqual(first, i + 1, m, second, j + 1, n);
    }

    private boolean isEqual(String s1, int fromIn1, int toEx1, String s2, int fromIn2, int toEx2) {
        if (toEx1 - fromIn1 != toEx2 - fromIn2) {
            return false;
        }
        int i = fromIn1, j = fromIn2;
        while (i < toEx1 && s1.charAt(i) == s2.charAt(j)) {
            i++;
            j++;
        }
        return i == toEx1;
    }
}