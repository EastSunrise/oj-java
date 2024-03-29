package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p1800.Solution1808;

/**
 * 343. Integer Break (Medium)
 *
 * @author Kingen
 * @see Solution1808
 * @see <a href="https://leetcode-cn.com/problems/integer-break/">Integer Break</a>
 */
public class Solution343 implements Solution {

    /**
     * Suppose that n=a[1]+...+a[k], p=a[1]*...*a[k].
     * <p>
     * If a[i]>=5, 2*(a[i]-2)>a[i], a[i] need to be split further. If a[i]==4, a[i]=2+2=2*2, split
     * a[i]. If a[i]=a[j]=a[k]=2, 2*2*2<3*3, merge the three numbers.
     * <p>
     * Therefore, a[i]=2 or a[i]=3 and the number of 2 is less than 3 which depends on n%3.
     *
     * @see Complexity#TIME_CONSTANT
     * @see Complexity#SPACE_CONSTANT
     * @see <a href="https://en.wikipedia.org/wiki/Inequality_of_arithmetic_and_geometric_means">Inequality
     * of arithmetic and geometric means</a>
     */
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int remainder = n % 3;
        int quotient = n / 3;
        if (remainder == 0) {
            return pow(3, quotient, MOD);
        } else if (remainder == 1) {
            return (int) (pow(3, quotient - 1, MOD) * 4L % MOD);
        } else {
            return pow(3, quotient, MOD) * 2 % MOD;
        }
    }
}
