package cn.kingen.oj.leetcode.problem.p400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/remove-k-digits/">402. Remove K Digits</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution321
 * @see cn.kingen.oj.leetcode.problem.p700.Solution738
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1673
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2195
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2259
 * @see cn.kingen.oj.leetcode.problem.p2800.Solution2844
 */
@Question(
        tags = {Tag.STACK, Tag.GREEDY, Tag.STRING, Tag.MONOTONIC_STACK},
        difficulty = Difficulty.MEDIUM
)
public class Solution402 {

    @Complexity(time = "O(n)", space = "O(1)")
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k >= n) {
            return "0";
        }

        char[] chars = num.toCharArray();
        int t = 0;
        for (int i = 0; i < n; i++) {
            while (k > 0 && t > 0 && chars[t - 1] > chars[i]) {
                t--;
                k--;
            }
            chars[t++] = chars[i];
        }
        t -= k;
        int s = 0;
        while (s < t && chars[s] == '0') {
            s++;
        }
        if (s == t) {
            return "0";
        }
        return new String(chars, s, t - s);
    }
}