package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-k-beauty-of-a-number/">2269. Find the K-Beauty of a Number</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.MATH, Tag.STRING, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.EASY,
        date = "2025-03-10"
)
public class Solution2269 {

    @Complexity(time = "O(n)", space = "O(1)", note = "n is the number of digits of num")
    public int divisorSubstrings(int num, int k) {
        int base = 1, sub = 0, left = num;
        while (k-- > 1) {
            sub += left % 10 * base;
            left /= 10;
            base *= 10;
        }

        int ans = 0;
        while (left > 0) {
            sub += left % 10 * base;
            if (sub != 0 && num % sub == 0) {
                ans++;
            }
            left /= 10;
            sub /= 10;
        }
        return ans;
    }
}