package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/design-an-atm-machine/">2241. Design an ATM Machine</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2000.Bank
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2224
 */
@Question(
    tags = {Tag.GREEDY, Tag.DESIGN, Tag.ARRAY},
    difficulty = Difficulty.MEDIUM,
        date = "2025-01-05"
)
public class ATM {

    private final int[][] banknotes;

    public ATM() {
        this.banknotes = new int[][]{
            {20, 0},
            {50, 0},
            {100, 0},
            {200, 0},
            {500, 0}
        };
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            banknotes[i][1] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] result = new int[5];
        for (int i = 4; i >= 0 && amount > 0; i--) {
            result[i] = Math.min(banknotes[i][1], amount / banknotes[i][0]);
            amount -= banknotes[i][0] * result[i];
        }
        if (amount > 0) {
            return new int[]{-1};
        }
        for (int i = 0; i < 5; i++) {
            banknotes[i][1] -= result[i];
        }
        return result;
    }
}