package wsg.oj.java.leetcode.problems.p1400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1432. Max Difference You Can Get From Changing an Integer (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/max-difference-you-can-get-from-changing-an-integer/">Max
 * Difference You Can Get From Changing an Integer</a>
 * @since 2021-07-27
 */
public class Solution1432 implements Solution {

    public int maxDiff(int num) {
        int[] digits = new int[9];
        int n = 0;
        while (num > 0) {
            digits[n++] = num % 10;
            num /= 10;
        }

        int x = 9;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                x = digits[i];
                break;
            }
        }
        int max = 0;
        // replace first non-9 digit with 9
        for (int i = n - 1; i >= 0; i--) {
            max = max * 10 + (digits[i] == x ? 9 : digits[i]);
        }

        int y;
        if (digits[n - 1] > 1) {
            x = digits[n - 1];
            y = 1;
        } else {
            x = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (digits[i] != 0 && digits[i] != 1) {
                    x = digits[i];
                    break;
                }
            }
            y = 0;
        }

        int min = 0;
        for (int i = n - 1; i >= 0; i--) {
            min = min * 10 + (digits[i] == x ? y : digits[i]);
        }
        return max - min;
    }
}
