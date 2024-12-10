package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-total-reward-using-operations-i/">3180. Maximum Total Reward Using Operations I</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3180 {

    @Complexity(time = "O(nm/C)", space = "O(m/C)", note = "C is 32")
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int n = rewardValues.length, m = rewardValues[n - 1] * 2;

        int[] mag = new int[m / 32 + 2];
        mag[0] = 1;
        int reward = 0;
        for (int rewardValue : rewardValues) {
            if (rewardValue == reward) {
                continue;
            }
            reward = rewardValue;

            shiftLeftAndOr(mag, reward);
        }

        for (int i = mag.length - 1; i >= 0; i--) {
            if (mag[i] != 0) {
                return ((i + 1) << 5) - Integer.numberOfLeadingZeros(mag[i]) - 1;
            }
        }
        return 0;
    }

    /**
     * mag |= 1 << x
     */
    private void shiftLeftAndOr(int[] mag, int x) {
        int t = x >>> 5;
        int r = x & 0x1f;

        if (r == 0) {
            for (int k = 0; k < t; k++) {
                mag[k + t] |= mag[k];
            }
        } else {
            int r2 = 32 - r;
            int last = mag[t] & ((1 << r) - 1);
            for (int k = 0; k < t; k++) {
                mag[k + t] |= mag[k] << r;
                mag[k + t + 1] |= mag[k] >>> r2;
            }
            mag[t + t] |= last << r;
            mag[t + t + 1] |= last >>> r2;
        }
    }
}