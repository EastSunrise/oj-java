package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

/**
 * <a href="https://leetcode.cn/problems/find-special-substring-of-length-k/">3456. Find Special Substring of Length K</a>
 *
 * @author Kingen
 */
@Question(
        difficulty = Difficulty.EASY,
        contest = 437
)
public class Solution3456 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean hasSpecialSubstring(String s, int k) {
        int n = s.length();
        for (int i = 0, j = 1; i < n; ) {
            char ch = s.charAt(i);
            while (j < n && s.charAt(j) == ch) {
                j++;
            }
            if (j - i == k) {
                return true;
            }
            i = j;
            j++;
        }
        return false;
    }
}