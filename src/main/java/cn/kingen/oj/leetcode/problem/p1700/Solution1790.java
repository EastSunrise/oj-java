package cn.kingen.oj.leetcode.problem.p1700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/">1790. Check if One String Swap Can Make Strings Equal</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p800.Solution859
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2531
 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.COUNTING},
        difficulty = Difficulty.EASY
)
public class Solution1790 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int i = -1, j = -1;
        for (int k = 0; k < n; k++) {
            if (s1.charAt(k) != s2.charAt(k)) {
                if (i == -1) {
                    i = k;
                } else if (j == -1) {
                    j = k;
                } else {
                    return false;
                }
            }
        }
        if (i == -1) {
            return true;
        }
        if (j == -1) {
            return false;
        }
        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }
}