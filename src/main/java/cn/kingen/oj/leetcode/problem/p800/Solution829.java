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
        // n=(m+1)+(m+2)+...+(m+k)=km+sum{1,...,k}, m>=0, k>=1
        int ans = 0, sum = 0;
        for (int k = 1; ; k++) {
            sum += k;
            if (sum > n) {
                break;
            }
            if ((n - sum) % k == 0) {
                ans++;
            }
        }
        return ans;
    }
}