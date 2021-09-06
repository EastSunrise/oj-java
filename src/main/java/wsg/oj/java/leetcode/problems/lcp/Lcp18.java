package wsg.oj.java.leetcode.problems.lcp;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * LCP 18. 早餐组合 (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/2vYnGI/">早餐组合</a>
 * @since 2021-07-28
 */
public class Lcp18 implements Solution {

    /**
     * @complexity T=O(m*log{m}+n*log{n}+m+n)
     * @complexity S=O(1)
     */
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int s = 0, d = drinks.length - 1, m = staple.length, cnt = 0;
        while (s < m && d >= 0) {
            if (staple[s] + drinks[d] <= x) {
                cnt = (cnt + d + 1) % 1_000_000_007;
                s++;
            } else {
                d--;
            }
        }
        return cnt;
    }
}
