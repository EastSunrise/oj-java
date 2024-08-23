package cn.kingen.oj.leetcode.problem.p3000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k/">3007. Maximum Number That Sum of the Prices Is Less Than or Equal to K</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.BINARY_SEARCH, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3007 {

    @Complexity(time = "O(x+log(k))", space = "O(1)")
    public long findMaximumNumber(long k, int x) {
        long num = 0, prev = 0;
        for (long i = 63 - Long.numberOfLeadingZeros((k + 1) << x); i >= 0; i--) {
            long cnt = (prev << i) + (i / x << i >> 1);
            if (cnt > k) {
                continue;
            }
            k -= cnt;
            num |= 1L << i;
            if ((i + 1) % x == 0) {
                prev++;
            }
        }
        return num - 1;
    }
}