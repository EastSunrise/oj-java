package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/score-of-a-string/">3110. Score of a String</a>
 *
 * @author Kingen
 */
@Question(
    tags = {Tag.STRING},
    difficulty = Difficulty.EASY,
    date = "2025-03-15"
)
public class Solution3110 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int scoreOfString(String s) {
        int n = s.length(), score = 0;
        for (int i = 1; i < n; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return score;
    }
}