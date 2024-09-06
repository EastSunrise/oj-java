package cn.kingen.oj.leetcode.problem.p2000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/">2024. Maximize the Confusion of an Exam</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution340
 * @see cn.kingen.oj.leetcode.problem.p400.Solution424
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1004
 * @see cn.kingen.oj.leetcode.problem.p1400.Solution1482
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2401
 */
@Question(
        tags = {Tag.STRING, Tag.BINARY_SEARCH, Tag.PREFIX_SUM, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution2024 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length(), ans = 0;
        int t = 0, f = 0;
        for (int i = 0, j = 0; j < n; i++) {
            while (j < n) {
                char ch = answerKey.charAt(j);
                if (ch == 'T' && (f <= k || t < k)) {
                    t++;
                    j++;
                } else if (ch == 'F' && (t <= k || f < k)) {
                    f++;
                    j++;
                } else break;
            }
            ans = Math.max(ans, j - i);
            if (answerKey.charAt(i) == 'T') {
                t--;
            } else {
                f--;
            }
        }
        return ans;
    }
}