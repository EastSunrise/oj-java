package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/substring-with-largest-variance/">2272. Substring With Largest Variance</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution53

 */
@Question(
    tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
    difficulty = Difficulty.HARD,
    date = "2025-03-16"
)
public class Solution2272 {

    @Complexity(time = "O(n*m^2)", space = "O(m)", note = "m is the number of distinct characters in s")
    public int largestVariance(String s) {
        int n = s.length(), m = 26;
        char[] chars = s.toCharArray();
        boolean[] has = new boolean[m];
        for (char c : chars) {
            has[c - 'a'] = true;
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (!has[i]) {
                continue;
            }
            for (int j = 0; j < m; j++) {
                if (!has[j] || i == j) {
                    continue;
                }
                char x = (char) ('a' + i), y = (char) ('a' + j);
                int dp = 0, dpy = Integer.MIN_VALUE; // dp is x's - y's variance
                for (int k = 0; k < n; k++) {
                    if (chars[k] == x) {
                        dpy++;
                        dp = Math.max(dp, 0) + 1;
                    } else if (chars[k] == y) {
                        dpy = Math.max(dp, 0) - 1;
                        dp = Math.max(dp, 0) - 1;
                    }
                    ans = Math.max(ans, dpy);
                }
            }
        }
        return ans;
    }
}