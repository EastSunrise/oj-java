package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/largest-3-same-digit-number-in-string/">2264. Largest 3-Same-Digit Number in String</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1900.Solution1903
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.EASY,
        daily = "2025-01-08"
)
public class Solution2264 {

    @Complexity(time = "O(n)", space = "O(1)")
    public String largestGoodInteger(String num) {
        int n = num.length();
        int d = -1, cnt = 0, max = -1;
        for (int i = 0; i < n; i++) {
            int c = num.charAt(i) - '0';
            if (c == d) {
                cnt++;
                if (cnt == 3) {
                    max = Math.max(max, d);
                }
            } else {
                d = c;
                cnt = 1;
            }
        }
        return max == -1 ? "" : String.valueOf(max).repeat(3);
    }
}