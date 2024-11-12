package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/maximum-energy-boost-from-two-drinks/">3259. Maximum Energy Boost From Two Drinks</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution3259 {

    @Complexity(time = "O(n)", space = "O(1)")
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long dpA = 0, dpB = 0;
        for (int i = 0; i < n; i++) {
            long a = dpA, b = dpB;
            dpA = Math.max(a + energyDrinkA[i], b);
            dpB = Math.max(a, b + energyDrinkB[i]);
        }
        return Math.max(dpA, dpB);
    }
}