package wsg.oj.java.leetcode.problems.p900;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 949. Largest Time for Given Digits (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/largest-time-for-given-digits/">Largest Time for
 * Given Digits</a>
 * @since 2021-07-27
 */
public class Solution949 implements Solution {

    /**
     * @see #DFS
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String largestTimeFromDigits(int[] arr) {
        Arrays.sort(arr);
        int[] res = new int[4];
        if (!permutation(arr, res, 0)) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(res[0]).append(res[1]).append(':').append(res[2]).append(res[3]);
        return builder.toString();
    }

    private boolean permutation(int[] arr, int[] tmp, int pos) {
        if (pos == 4) {
            return true;
        }
        for (int i = 3; i >= 0; i--) {
            if (arr[i] >= 0) {
                tmp[pos] = arr[i];
                arr[i] = -1;
                if (isValid(tmp, pos) && permutation(arr, tmp, pos + 1)) {
                    return true;
                }
                arr[i] = tmp[pos];
            }
        }
        return false;
    }

    private boolean isValid(int[] arr, int pos) {
        if (pos == 0) {
            return arr[0] <= 2;
        }
        if (pos == 1) {
            return arr[0] * 10 + arr[1] < 24;
        }
        if (pos == 2) {
            return arr[2] < 6;
        }
        return true;
    }
}
