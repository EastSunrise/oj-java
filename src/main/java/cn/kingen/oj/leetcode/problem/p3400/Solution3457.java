package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/eat-pizzas/">3457. Eat Pizzas!</a>
 *
 * @author Kingen
 */
@Question(
        difficulty = Difficulty.MEDIUM,
        contest = 437
)
public class Solution3457 {

    @Complexity(time = "O(n)", space = "O(1)")
    public long maxWeight(int[] pizzas) {
        int n = pizzas.length, k = n >> 2, p = k >> 1, q = k - p;
        Arrays.sort(pizzas);
        long sum = 0;
        for (int i = n - q; i < n; i++) {
            sum += pizzas[i];
        }
        for (int i = n - q - 2 * p; i < n - q; i += 2) {
            sum += pizzas[i];
        }
        return sum;
    }
}