package wsg.oj.java.leetcode.problems.p800;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 869. Reordered Power of 2 (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/reordered-power-of-2/">Reordered Power of 2</a>
 * @since 2021-07-27
 */
public class Solution869 implements Solution {

    /**
     * @complexity T=O(log{n}*lon{n})
     * @complexity S=O(log{n})
     */
    public boolean reorderedPowerOf2(int n) {
        int[] cnt = stat(n);
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(cnt, stat(1 << i))) {
                return true;
            }
        }
        return false;
    }

    private int[] stat(int n) {
        int[] cnt = new int[10];
        while (n > 0) {
            cnt[n % 10]++;
            n /= 10;
        }
        return cnt;
    }
}
