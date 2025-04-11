package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-symmetric-integers/">2843.   Count Symmetric Integers</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution9
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1837
 */
@Question(
    tags = {Tag.MATH, Tag.ENUMERATION},
    difficulty = Difficulty.EASY,
    date = "2025-04-11"
)
public class Solution2843 {

    @Complexity(time = "O(C^2*n^3)", space = "O(C*n^3)", note = "C is 10")
    public int countSymmetricIntegers(int low, int high) {
        int[] highArr = String.valueOf(high).chars().map(c -> c - '0').toArray();
        int n = highArr.length;
        int[] lowArr = new int[n];
        for (int i = n - 1; low > 0; i--) {
            lowArr[i] = low % 10;
            low /= 10;
        }
        int[][][][] memo = new int[n][n][n / 2 * 9 + 1][4];
        return dfs(memo, lowArr, highArr, -1, 0, 0, 3);
    }

    private int dfs(int[][][][] memo, int[] low, int[] high, int start, int i, int diff, int limit) {
        if (i == high.length) {
            return start >= 0 && diff == 0 ? 1 : 0;
        }
        if (diff < 0) {
            return 0;
        }
        if (memo[start + 1][i][diff][limit] > 0) {
            return memo[start + 1][i][diff][limit];
        }

        int mn = (limit & 1) > 0 ? low[i] : 0;
        int mx = (limit & 2) > 0 ? high[i] : 9;

        int cnt = 0;
        if (start < 0 && (high.length - i) % 2 == 1) { // cannot start from this position
            cnt = mn > 0 ? 0 : dfs(memo, low, high, start, i + 1, diff, 1);
        } else {
            boolean isLeft = start < 0 || high.length - i > i - start;
            for (int d = mn; d <= mx; d++) {
                int mask = (d == mn ? 1 : 0) | (d == mx ? 2 : 0);
                int st = start < 0 && d > 0 ? i : start;
                cnt += dfs(memo, low, high, st, i + 1, isLeft ? diff + d : diff - d, limit & mask);
            }
        }
        return memo[start + 1][i][diff][limit] = cnt;
    }
}