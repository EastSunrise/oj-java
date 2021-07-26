package wsg.oj.java.leetcode.problems.p200;

import java.util.Set;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution141;

/**
 * 202. Happy Number (Easy)
 *
 * @author Kingen
 * @see Solution141
 * @see Solution258
 * @see Solution263
 * @see <a href="https://leetcode-cn.com/problems/happy-number/">Happy Number</a>
 * @since 2021-07-12
 */
public class Solution202 implements Solution {

    /**
     * Assumes that n=a1a2...ak and the sum of squares of each digit is S. Then
     * <p>If k>3, S=a1^2+a2^2+...+ak^2<=81k<10^(k-1)<n </p>
     * <p>If k=3, S=a1^2+a2^2+a3^2<=243</>
     * Therefore, the result will be less than 244 no matter how large n is. Calculate all numbers
     * less than 244, and all will end with 1 except those unhappy numbers showed in the method.
     *
     * @see wsg.oj.java.Complexity#TIME_CONSTANT
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public boolean isHappy(int n) {
        Set<Integer> unhappy = Set.of(2, 4, 16, 37, 58, 89, 145, 42, 20);
        while (n != 1) {
            if (unhappy.contains(n)) {
                return false;
            }
            int sum = 0;
            while (n > 0) {
                int mod = n % 10;
                sum += mod * mod;
                n /= 10;
            }
            n = sum;
        }
        return true;
    }
}
