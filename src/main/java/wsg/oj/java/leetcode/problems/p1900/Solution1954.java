package wsg.oj.java.leetcode.problems.p1900;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1954. Minimum Garden Perimeter to Collect Enough Apples (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/minimum-garden-perimeter-to-collect-enough-apples/">Minimum
 * Garden Perimeter to Collect Enough Apples</a>
 * @since 2021-08-28
 */
public class Solution1954 implements Solution {

    public long minimumPerimeter(long neededApples) {
        neededApples = (neededApples - 1) / 12 + 1;
        long cnt = 0;
        long i = 0;
        while (cnt < neededApples) {
            i++;
            cnt += i * i;
        }
        return 8 * i;
    }
}
