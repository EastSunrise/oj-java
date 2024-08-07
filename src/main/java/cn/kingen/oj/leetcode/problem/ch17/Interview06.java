package cn.kingen.oj.leetcode.problem.ch17;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/number-of-2s-in-range-lcci/">面试题 17.06. Number Of 2s In Range LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.RECURSION, Tag.MATH, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.HARD
)
public class Interview06 {

    @Complexity(time = "O(log{n})", space = "O(1)")
    public int numberOf2sInRange(int n) {
        int ans = 0;
        int mask = 1, bit = 0;
        while (mask < n) {
            mask *= 10;
            bit++;
        }

        while (bit > 0) {
            bit--;
            mask /= 10;
            // 10^bit = mask <= n = ab...cd < 10^(bit+1)
            // a=n/mask, b...cd=n%mask
            int a = n / mask;
            // count 2s at first digit
            if (a == 2) { // a=2 and b...cd is in [0,n%mask]
                ans += n % mask + 1;
            } else if (a > 2) { // a=2 and b...cd is in [0,mask-1]
                ans += mask;
            }
            // count 2s in b...cd when the first digit is in [0,a-1]
            ans += a * bit * (mask / 10);
            // count 2s in b...cd when the first digit is a
            n %= mask;
        }
        return ans;
    }
}