package cn.kingen.oj.leetcode.problem.p500;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/student-attendance-record-i/">551. Student Attendance Record I</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p500.Solution552

 */
@Question(
    tags = {Tag.STRING},
    difficulty = Difficulty.EASY
)
public class Solution551 {

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean checkRecord(String s) {
        int n = s.length(), a = 0, l = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                a++;
                if (a > 1) {
                    return false;
                }
            }
            if (c == 'L') {
                l++;
                if (l > 2) {
                    return false;
                }
            } else {
                l = 0;
            }
        }
        return true;
    }
}