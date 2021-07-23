package wsg.oj.java.leetcode.problems.p600;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p500.Solution547;

/**
 * 657. Robot Return to Origin (EASY)
 *
 * @author Kingen
 * @see Solution547
 * @see <a href="https://leetcode-cn.com/problems/robot-return-to-origin/">Robot Return to
 * Origin</a>
 * @since 2021-07-23
 */
public class Solution657 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'U') {
                x++;
            } else if (ch == 'D') {
                x--;
            } else if (ch == 'L') {
                y--;
            } else {
                y++;
            }
        }
        return x == 0 && y == 0;
    }
}
