package wsg.oj.java.leetcode.problems.p400;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 492. Construct the Rectangle (Easy)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/construct-the-rectangle/">Construct the
 * Rectangle</a>
 * @since 2021-07-14
 */
public class Solution492 implements Solution {

    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            w--;
        }
        return new int[]{area / w, w};
    }
}
