package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/consecutive-numbers-sum/">829. Consecutive Numbers Sum</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.MATH, Tag.ENUMERATION},
        difficulty = Difficulty.HARD
)
public class Solution829 {

    @Complexity(time = "O(sqrt{n})", space = "O(1)")
    public int consecutiveNumbersSum(int n) {
        // n=(m+0)+(m+1)+...+(m+k-1)=km+sum{0,...,k-1}, m>=0, k>=0
        int ans = 0;
        for (int k = 1; n > 0; k++) {
            if (n % k == 0) {
                ans++;
            }
            n -= k;
        }
        return ans;
    }
}