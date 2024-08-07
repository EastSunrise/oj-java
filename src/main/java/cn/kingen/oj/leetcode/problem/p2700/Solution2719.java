package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

/**
 * <a href="https://leetcode.cn/problems/count-of-integers/">2719. Count of Integers</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.MATH, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Solution2719 {

    int[] zeros;
    int[] nines;

    @Complexity(time = "O(n*max_sum*10)", space = "O(n*max_sum)")
    public int count(String num1, String num2, int min_sum, int max_sum) {
        int m = num1.length(), n = num2.length();
        int[] arr1 = new int[n], arr2 = new int[n];
        for (int i = 0; i < m; i++) {
            arr1[i + n - m] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = num2.charAt(i) - '0';
        }

        zeros = new int[n];
        nines = new int[n];
        for (int i = 0; i < n; i++) {
            nines[i] = 9;
        }
        int[][] memo = new int[n][max_sum + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(memo, arr1, arr2, min_sum, max_sum, 0, 0, 0b11);
    }

    private int dfs(int[][] memo, int[] arr1, int[] arr2, int min_sum, int max_sum, int sum, int i, int limit) {
        if (sum > max_sum) {
            return 0;
        }
        if (i >= arr2.length) {
            return sum >= min_sum ? 1 : 0;
        }
        if (limit == 0 && memo[i][sum] != -1) {
            return memo[i][sum];
        }

        int cnt = 0;
        if (arr1[i] == arr2[i]) {
            cnt = dfs(memo, arr1, arr2, min_sum, max_sum, sum + arr1[i], i + 1, limit & 0b11);
        } else {
            cnt = (cnt + dfs(memo, arr1, nines, min_sum, max_sum, sum + arr1[i], i + 1, limit & 0b10)) % MOD;
            for (int d = arr1[i] + 1; d < arr2[i]; d++) {
                cnt = (cnt + dfs(memo, zeros, nines, min_sum, max_sum, sum + d, i + 1, 0b00)) % MOD;
            }
            cnt = (cnt + dfs(memo, zeros, arr2, min_sum, max_sum, sum + arr2[i], i + 1, limit & 0b01)) % MOD;
        }
        if (limit == 0) {
            memo[i][sum] = cnt;
        }
        return cnt;
    }
}