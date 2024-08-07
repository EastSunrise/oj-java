package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import static cn.kingen.oj.leetcode.util.MathUtils.MOD;
import static cn.kingen.oj.leetcode.util.MathUtils.fastPow;

/**
 * <a href="https://leetcode.cn/problems/integer-break/">343. Integer Break</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1808
 */
@Question(
        tags = {Tag.MATH, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution343 {

    /**
     * Suppose that n=a[1]+...+a[k], p=a[1]*...*a[k].
     * <ul>
     *     <li>If a[i]>=5, 2*(a[i]-2)>a[i], a[i] need to be split further.</li>
     *     <li>If a[i]==4, a[i]=2+2=2*2, split a[i].</li>
     *     <li>If a[i]=a[j]=a[k]=2, 2*2*2<3*3, merge the three numbers.</li>
     * </ul>
     * Therefore, a[i]=2 or a[i]=3 and the number of 2 is less than 3 which depends on n%3.
     * <p>
     * Refers to <a href="https://en.wikipedia.org/wiki/Inequality_of_arithmetic_and_geometric_means">Inequality
     * of arithmetic and geometric means</a>
     */
    @Complexity(time = "O(log{n})", space = "O(1)")
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int remainder = n % 3;
        int quotient = n / 3;
        if (remainder == 0) {
            return (int) fastPow(3, quotient);
        } else if (remainder == 1) {
            return (int) (fastPow(3, quotient - 1) * 4L % MOD);
        } else {
            return (int) (fastPow(3, quotient) * 2 % MOD);
        }
    }
}