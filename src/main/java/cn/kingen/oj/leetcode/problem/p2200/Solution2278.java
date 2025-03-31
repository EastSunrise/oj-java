package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/percentage-of-letter-in-string/">2278. Percentage of Letter in String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p400.Solution451
 */
@Question(
    tags = {Tag.STRING},
    difficulty = Difficulty.EASY,
    date = "2025-03-31"
)
public class Solution2278 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int percentageLetter(String s, char letter) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                cnt++;
            }
        }
        return cnt * 100 / s.length();
    }
}