package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-largest-palindrome-divisible-by-k/">3260. Find the Largest Palindrome Divisible by K</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution9
 * @see cn.kingen.oj.leetcode.problem.p500.Solution564
 */
@Question(
        tags = {Tag.GREEDY, Tag.MATH, Tag.STRING, Tag.DYNAMIC_PROGRAMMING, Tag.NUMBER_THEORY},
        difficulty = Difficulty.HARD,
        contest = 411
)
public class Solution3260 {

    @Complexity(time = "O(nkC)", space = "O(nk)", note = "C is 10")
    public String largestPalindrome(int n, int k) {
        if (k == 1 || k == 3 || k == 9) { // 9...9
            return "9".repeat(n);
        }
        if (k == 2) { // 89...98
            return n <= 2 ? "8".repeat(n) : "8" + "9".repeat(n - 2) + "8";
        }
        if (k == 4) { // 889...988
            return n <= 4 ? "8".repeat(n) : "88" + "9".repeat(n - 4) + "88";
        }
        if (k == 8) { // 8889...9888
            return n <= 6 ? "8".repeat(n) : "888" + "9".repeat(n - 6) + "888";
        }
        if (k == 5) { // 59...95
            return n == 1 ? "5" : "5" + "9".repeat(n - 2) + "5";
        }
        if (k == 6) {
            if (n <= 2) { // 6 or 66
                return "6".repeat(n);
            }
            if ((n & 1) == 0) { // 89...9779...98
                int nines = (n - 4) / 2;
                return "8" + "9".repeat(nines) + "77" + "9".repeat(nines) + "8";
            } else { // 89...989...98
                int nines = (n - 3) / 2;
                return "8" + "9".repeat(nines) + "8" + "9".repeat(nines) + "8";
            }
        }

        // dp[i][r] is the largest palindrome v with length i and v % k == r
        int[] mods = new int[n];
        mods[0] = 1;
        for (int i = 1; i < n; i++) {
            mods[i] = mods[i - 1] * 10 % k;
        }
        char[] num = new char[n];
        dfs(new boolean[n][k], mods, 0, n - 1, k, 0, num);
        return new String(num);
    }

    private boolean dfs(boolean[][] visited, int[] mods, int i, int j, int k, int r, char[] num) {
        if (i > j) {
            return r == 0;
        }
        if (visited[i][r]) {
            return false;
        }

        if (i == j) {
            for (int x = 9; x >= 0; x--) {
                if (x * mods[i] % k == r) {
                    num[i] = (char) ('0' + x);
                    return true;
                }
            }
            visited[i][r] = true;
            return false;
        }

        for (int x = 9; x >= 0; x--) {
            num[i] = num[j] = (char) ('0' + x);
            int ri = (x * mods[i] + x * mods[j]) % k;
            if (dfs(visited, mods, i + 1, j - 1, k, (r + k - ri) % k, num)) {
                return true;
            }
        }
        visited[i][r] = true;
        return false;
    }
}