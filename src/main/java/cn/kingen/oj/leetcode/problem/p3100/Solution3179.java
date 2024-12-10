package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;

/**
 * <a href="https://leetcode.cn/problems/find-the-n-th-value-after-k-seconds/">3179. Find the N-th Value After K Seconds</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2574
 */
@Question(
        tags = {Tag.ARRAY, Tag.MATH, Tag.COMBINATORICS, Tag.PREFIX_SUM, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution3179 {

    @Complexity(time = "O(nk)", space = "O(n)")
    public int valueAfterKSeconds(int n, int k) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        while (k-- > 0) {
            for (int i = 1; i < n; i++) {
                arr[i] = (arr[i - 1] + arr[i]) % MOD;
            }
        }
        return arr[n - 1];
    }
}