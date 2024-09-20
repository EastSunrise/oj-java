package cn.kingen.oj.leetcode.problem.p2400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/length-of-the-longest-alphabetical-continuous-substring/">2414. Length of the Longest Alphabetical Continuous Substring</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution128
 * @see cn.kingen.oj.leetcode.problem.p400.Solution413
 * @see cn.kingen.oj.leetcode.problem.p400.Solution485
 * @see cn.kingen.oj.leetcode.problem.p1400.Solution1456
 * @see cn.kingen.oj.leetcode.problem.p2300.Solution2348
 */
@Question(
        tags = {Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution2414 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ) {
            int j = i + 1;
            while (j < n && s.charAt(j) == s.charAt(j - 1) + 1) {
                j++;
            }
            ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;
    }
}