package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-substrings-that-satisfy-k-constraint-i/">3258. Count Substrings That Satisfy K-Constraint I</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STRING, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.EASY,
        contest = 411
)
public class Solution3258 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int[] cnt = new int[2];
        int ans = 0, ch;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && (cnt[(ch = s.charAt(j) - '0')] < k || cnt[1 - ch] <= k)) {
                cnt[ch]++;
                j++;
            }
            ans += j - i;
            cnt[s.charAt(i) - '0']--;
        }
        return ans;
    }
}