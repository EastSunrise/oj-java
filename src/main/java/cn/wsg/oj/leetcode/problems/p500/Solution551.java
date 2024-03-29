package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 551. Student Attendance Record I (EASY)
 *
 * @author Kingen
 * @see Solution552
 * @see <a href="https://leetcode-cn.com/problems/student-attendance-record-i/">Student Attendance
 * Record I</a>
 */
class Solution551 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public boolean checkRecord(String s) {
        int totalAbsent = 0, consecutiveLate = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                if (++consecutiveLate > 2) {
                    return false;
                }
            } else {
                consecutiveLate = 0;
                if (ch == 'A') {
                    totalAbsent++;
                }
            }
        }
        return totalAbsent < 2;
    }
}
