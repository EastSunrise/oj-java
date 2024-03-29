package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p300.Solution321;
import java.util.Arrays;

/**
 * 670. Maximum Swap (MEDIUM)
 *
 * @author Kingen
 * @see Solution321
 * @see <a href="https://leetcode-cn.com/problems/maximum-swap/">Maximum Swap</a>
 */
public class Solution670 implements Solution {

    /**
     * @complexity T=(32*log32)
     * @complexity S=O(32)
     */
    public int maximumSwap(int num) {
        if (num < 10) {
            return num;
        }
        int[] digits = new int[32];
        int n = 0, copy = num;
        while (copy > 0) {
            digits[n++] = copy % 10;
            copy /= 10;
        }
        int[] sorted = Arrays.copyOf(digits, n);
        Arrays.sort(sorted);
        int i = n - 1;
        while (i >= 0 && digits[i] == sorted[i]) {
            i--;
        }
        if (i < 0) {
            return num;
        }
        int higher = sorted[i];
        int j = 0;
        while (digits[j] != higher) {
            j++;
        }
        // swap the two digits
        digits[j] = digits[i];
        digits[i] = higher;
        int res = 0;
        for (int k = n - 1; k >= 0; k--) {
            res = res * 10 + digits[k];
        }
        return res;
    }
}
