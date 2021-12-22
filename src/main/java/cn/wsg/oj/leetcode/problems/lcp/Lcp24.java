package cn.wsg.oj.leetcode.problems.lcp;

import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * LCP 24. 数字游戏 (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/5TxKeK/">数字游戏</a>
 */
public class Lcp24 implements Solution {

    public int[] numsGame(int[] nums) {
        int n = nums.length, sum = 0;
        int[] counts = new int[n];
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            int ds = (i - 1) * i / 2;
            int cnt = (sum - ds) / i * i + ds;
            counts[i - 1] = Math.min(sum - cnt, cnt + i - sum);
        }
        return counts;
    }
}
