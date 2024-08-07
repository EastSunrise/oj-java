package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-swap/">670. Maximum Swap</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution321
 */
@Question(
        tags = {Tag.GREEDY, Tag.MATH},
        difficulty = Difficulty.MEDIUM
)
public class Solution670 {

    @Complexity(time = "C*log{C}", space = "C", note = "C is the number of digits")
    public int maximumSwap(int num) {
        if (num < 10) {
            return num;
        }
        int[] digits = new int[9];
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

        int j = 0;
        while (digits[j] != sorted[i]) {
            j++;
        }
        // swap the two digits
        digits[j] = digits[i];
        digits[i] = sorted[i];
        int res = 0;
        for (int k = n - 1; k >= 0; k--) {
            res = res * 10 + digits[k];
        }
        return res;
    }
}