package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p100.Solution172;

/**
 * 233. Number of Digit One (HARD)
 *
 * @author Kingen
 * @see Solution172
 * @see Solution1067
 * @see <a href="https://leetcode-cn.com/problems/number-of-digit-one/">Number of Digit One</a>
 */
public class Solution233 implements Solution {

    /**
     * @complexity T=O(k), k=log_{10}{n}
     * @complexity S=O(1)
     */
    public int countDigitOne(int n) {
        int pow = 1, count = 0, prefix = n / 10, d = n % 10;
        while (prefix != 0 || d != 0) {
            // abc1xxx: 0 <= abc < prefix, 0 <= xxx <= 999
            count += prefix * pow;
            // prefix-d-suffix
            if (d == 1) {
                // prefix-1-ijk: 0 <= ijk <= suffix
                count += n % pow + 1;
            } else if (d > 1) {
                // prefix-1-xxx: 0 <= xxx <= 999
                count += pow;
            }
            pow *= 10;
            d = prefix % 10;
            prefix /= 10;
        }
        return count;
    }
}
