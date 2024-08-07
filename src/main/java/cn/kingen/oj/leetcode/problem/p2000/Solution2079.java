package cn.kingen.oj.leetcode.problem.p2000;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/watering-plants/">2079. Watering Plants</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2105
 */
@Question(
        tags = {Tag.ARRAY, Tag.SIMULATION},
        difficulty = Difficulty.MEDIUM
)
public class Solution2079 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int ans = 0, water = capacity;
        for (int i = 0; i < n; i++) {
            if (water < plants[i]) {
                ans += i * 2;
                water = capacity;
            }
            ans++;
            water -= plants[i];
        }
        return ans;
    }
}