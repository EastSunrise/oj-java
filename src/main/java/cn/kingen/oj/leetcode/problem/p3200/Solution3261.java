package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-substrings-that-satisfy-k-constraint-ii/">3261. Count Substrings That Satisfy K-Constraint II</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.STRING, Tag.BINARY_SEARCH, Tag.PREFIX_SUM, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.HARD,
        contest = 411
)
public class Solution3261 {

    @Complexity(time = "O(n+q)", space = "O(n)")
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        int n = s.length();
        int[] cnt = new int[2], lefts = new int[n];
        long[] prefix = new long[n + 1];
        for (int i = 0, j = 0; i < n; i++) {
            int ch;
            while (j < n && (cnt[(ch = s.charAt(j) - '0')] < k || cnt[1 - ch] <= k)) {
                cnt[ch]++;
                lefts[j++] = i; // [i,j] valid while [i-1,j] not
            }
            prefix[i + 1] = prefix[i] + j - i;
            cnt[s.charAt(i) - '0']--;
        }

        int q = queries.length;
        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0], r = queries[i][1];
            int j = Math.max(l, lefts[r]);
            long sum = prefix[j] - prefix[l];
            sum += (long) (r - j + 1) * (r - j + 2) / 2;
            ans[i] = sum;
        }
        return ans;
    }
}