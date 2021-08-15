package wsg.oj.java.leetcode.problems.p100;

import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution233;

/**
 * 172. Factorial Trailing Zeroes (Easy)
 *
 * @author Kingen
 * @see Solution233
 * @see Solution793
 * @see <a href="https://leetcode-cn.com/problems/factorial-trailing-zeroes/">Factorial Trailing
 * Zeroes</a>
 * @since 2021-07-12
 */
public class Solution172 implements Solution {

    /**
     * n!=2^i*5^j*p^k, i>=j, gcd(5,p)=1, so the number of zeros is the number of factor 5.
     *
     * @complexity T=(m), m=log_{5}{n}
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
