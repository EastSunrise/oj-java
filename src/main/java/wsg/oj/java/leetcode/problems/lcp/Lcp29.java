package wsg.oj.java.leetcode.problems.lcp;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * LCP 29. 乐团站位 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/SNJvJP/">乐团站位</a>
 * @since 2021-07-28
 */
public class Lcp29 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int orchestraLayout(int num, int xPos, int yPos) {
        int d = Math.min(Math.min(xPos, num - 1 - xPos), Math.min(yPos, num - 1 - yPos));
        int cnt = (num - d) % 9 * (d % 9) * 4;
        int side = num - 1 - 2 * d;
        int min = (num - side - 1) / 2;
        int max = min + side;
        side %= 9;
        if (xPos == min) {
            cnt += yPos - min + 1;
        } else if (yPos == max) {
            cnt += side + xPos - min + 1;
        } else if (xPos == max) {
            cnt += 2 * side + max - yPos + 1;
        } else {
            cnt += 3 * side + max - xPos + 1;
        }
        cnt %= 9;
        return cnt == 0 ? 9 : cnt;
    }
}
