package cn.kingen.oj.leetcode.problem.p1000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/grumpy-bookstore-owner/">1052. Grumpy Bookstore Owner</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM
)
public class Solution1052 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int base = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                base += customers[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
        }
        int max = sum;
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                sum -= customers[i - minutes];
            }
            max = Math.max(max, sum);
        }
        return base + max;
    }
}