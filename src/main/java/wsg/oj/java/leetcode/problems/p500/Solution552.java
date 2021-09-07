package wsg.oj.java.leetcode.problems.p500;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 552. Student Attendance Record II (HARD)
 *
 * @author Kingen
 * @see Solution551
 * @see <a href="https://leetcode-cn.com/problems/student-attendance-record-ii/">Student Attendance
 * Record II</a>
 * @since 2021-07-27
 */
public class Solution552 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int checkRecord(int n) {
        if (n == 1) {
            return 3;
        }
        int[] present = new int[n], total = new int[n];
        present[0] = 1;
        present[1] = total[0] = 2;
        total[1] = 4;
        for (int i = 2; i < n; i++) {
            present[i] = total[i - 1];
            total[i] = ((present[i] + present[i - 1]) % MOD + present[i - 2]) % MOD;
        }
        long absent = 0;
        for (int i = 1; i < n - 1; i++) {
            absent = (absent + total[i - 1] * (long) total[n - 2 - i]) % MOD;
        }
        absent += 2 * (long) total[n - 2];
        return (int) ((absent + (long) total[n - 1]) % MOD);
    }
}
