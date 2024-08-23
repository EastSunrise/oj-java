package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/minimum-array-end/">3133. Minimum Array End</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution3133 {

    @Complexity(time = "O(log(n)+log(x))", space = "O(1)")
    public long minEnd(int n, int x) {
        n--;
        long ans = x, p = 0;
        while (n > 0) {
            while ((ans >> p & 1) == 1) { // find a 0-bit
                p++;
            }
            ans |= (n & 1L) << p; // fill with bit of n
            n >>= 1;
            p++;
        }
        return ans;
    }
}