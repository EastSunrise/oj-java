package cn.kingen.oj.leetcode.problem.p2100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/watering-plants-ii/">2105. Watering Plants II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2079
 */
@Question(
        tags = {Tag.ARRAY, Tag.TWO_POINTERS, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution2105 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int waterA = capacityA, waterB = capacityB;
        int ans = 0, i = 0, j = plants.length - 1;
        while (i < j) {
            if (waterA < plants[i]) {
                waterA = capacityA;
                ans++;
            }
            waterA -= plants[i];
            i++;

            if (waterB < plants[j]) {
                waterB = capacityB;
                ans++;
            }
            waterB -= plants[j];
            j--;
        }
        if (i == j) {
            if (Math.max(waterA, waterB) < plants[i]) {
                ans++;
            }
        }
        return ans;
    }
}