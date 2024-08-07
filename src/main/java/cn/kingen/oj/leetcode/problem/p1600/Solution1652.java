package cn.kingen.oj.leetcode.problem.p1600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/defuse-the-bomb/">1652. Defuse the Bomb</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2400.Solution2490
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2515
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2516
 */
@Question(
        tags = {Tag.ARRAY, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.EASY
)
public class Solution1652 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }
        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                ans[0] += code[i];
            }
            for (int i = 1; i < n; i++) {
                ans[i] = ans[i - 1] - code[i] + code[(i + k) % n];
            }
        } else {
            for (int i = n + k; i < n; i++) {
                ans[0] += code[i];
            }
            for (int i = 1; i < n; i++) {
                ans[i] = ans[i - 1] + code[i - 1] - code[(i - 1 + k + n) % n];
            }
        }
        return ans;
    }
}