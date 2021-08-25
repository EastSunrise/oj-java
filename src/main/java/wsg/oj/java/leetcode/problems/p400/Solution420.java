package wsg.oj.java.leetcode.problems.p400;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 420. Strong Password Checker (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/strong-password-checker/">Strong Password
 * Checker</a>
 * @since 2021-07-27
 */
public class Solution420 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int strongPasswordChecker(String password) {
        boolean lower = false, upper = false, digit = false;
        List<Integer> counts = new ArrayList<>();
        char prev = '^';
        int count = 0;
        for (char ch : (password + '$').toCharArray()) {
            if (ch >= '0') {
                if (ch <= '9') {
                    digit = true;
                } else if (ch <= 'Z') {
                    upper = true;
                } else {
                    lower = true;
                }
            }
            if (ch == prev) {
                count++;
            } else {
                prev = ch;
                if (count >= 3) {
                    counts.add(count);
                }
                count = 1;
            }
        }
        int n = password.length();
        int missing = (lower ? 0 : 1) + (upper ? 0 : 1) + (digit ? 0 : 1);
        if (n < 6) {
            // insert missing types first
            return Math.max(missing, 6 - n);
        }

        int replace = 0;
        for (int cnt : counts) {
            replace += cnt / 3;
        }
        if (n <= 20) {
            // replace with missing types first
            return Math.max(missing, replace);
        }

        int[] mod = new int[3];
        for (int cnt : counts) {
            mod[cnt % 3]++;
        }
        int delete = n - 20;
        if (delete <= mod[0]) {
            replace -= delete;
            // delete 'aaa' to 'aa'
            // then replace with missing types first
            return n - 20 + Math.max(missing, replace);
        }
        delete -= mod[0];
        replace -= mod[0];
        if (delete <= mod[1] * 2) {
            // delete 'aaa' to 'aa'
            // delete 'aaaa' to 'aa'
            // then replace with missing types first
            replace -= delete / 2;
            return n - 20 + Math.max(missing, replace);
        }
        delete -= mod[1] * 2;
        replace -= mod[1];
        replace -= delete / 3;
        return n - 20 + Math.max(missing, replace);
    }
}
