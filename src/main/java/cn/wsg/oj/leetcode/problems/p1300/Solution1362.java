package cn.wsg.oj.leetcode.problems.p1300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 1362. Closest Divisors (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/closest-divisors/">Closest Divisors</a>
 */
public class Solution1362 implements Solution {

    /**
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
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
