package wsg.oj.java.leetcode.problems.p1300;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1362. Closest Divisors (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/closest-divisors/">Closest Divisors</a>
 * @since 2021-07-27
 */
public class Solution1362 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int[] closestDivisors(int num) {
        int num1 = num + 1, num2 = num + 2;
        int low = (int) Math.sqrt(num + 2);
        while (true) {
            if (num1 % low == 0) {
                return new int[]{low, num1 / low};
            }
            if (num2 % low == 0) {
                return new int[]{low, num2 / low};
            }
            low--;
        }
    }
}
