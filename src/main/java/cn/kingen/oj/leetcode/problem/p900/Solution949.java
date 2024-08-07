package cn.kingen.oj.leetcode.problem.p900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/largest-time-for-given-digits/">949. Largest Time for Given Digits</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2437
 */
@Question(
        tags = {Tag.ARRAY, Tag.STRING, Tag.ENUMERATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution949 {

    @Complexity(time = "O(1)", space = "O(1)")
    public String largestTimeFromDigits(int[] arr) {
        Arrays.sort(arr);
        int[] res = new int[4];
        if (!permutation(arr, res, 0)) {
            return "";
        }
        return String.valueOf(res[0]) + res[1] + ':' + res[2] + res[3];
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