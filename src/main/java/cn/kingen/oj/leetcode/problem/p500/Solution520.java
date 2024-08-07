package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/detect-capital/">520. Detect Capital</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2129
 * @see cn.kingen.oj.leetcode.problem.p3100.Solution3121
 * @see cn.kingen.oj.leetcode.problem.p3100.Solution3120
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution520 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n == 1) {
            return true;
        }
        boolean upper = word.charAt(n - 1) < 'a';
        for (int i = n - 2; i >= 1; i--) {
            if ((word.charAt(i) < 'a') ^ upper) {
                return false;
            }
        }
        return !upper || word.charAt(0) < 'a';
    }
}