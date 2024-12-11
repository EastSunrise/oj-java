package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-total-damage-with-spell-casting/">3186. Maximum Total Damage With Spell Casting</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.TWO_POINTERS, Tag.BINARY_SEARCH, Tag.DYNAMIC_PROGRAMMING, Tag.COUNTING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3186 {

    @Complexity(time = "O(n*log(n))", space = "O(n)")
    public long maximumTotalDamage(int[] power) {
        int n = power.length;
        Arrays.sort(power);

        // dpi[i] is max damage ending with power[i-1], dp[i] is max damage for power[0,...,i-1]
        long[] dpi = new long[n + 1], dp = new long[n + 1];
        // pointers of first occurrence of power[i], power[i]-x, power[i]-y, power[i]-z where 0<x<y<z
        int[] p = new int[]{-1, -1, -1, -1};
        for (int i = 0; i < n; i++) {
            if (p[0] != -1 && power[i] == power[p[0]]) { // same power
                dpi[i + 1] = dpi[i] + power[i];
            } else {
                dpi[i + 1] = power[i];

                for (int j = 3; j >= 1; j--) { // shift pointers by 1
                    p[j] = p[j - 1];
                }
                p[0] = i;
            }

            int k = 0;
            for (int j = 1; j < 4; j++) { // find the last one that less than power[i]-2
                if (p[j] == -1 || power[p[j]] < power[i] - 2) {
                    k = p[j - 1] - 1;
                    break;
                }
            }
            dpi[i + 1] = Math.max(dpi[i + 1], dp[k + 1] + power[i]);
            dp[i + 1] = Math.max(dp[i], dpi[i + 1]);
        }
        return dp[n];
    }
}