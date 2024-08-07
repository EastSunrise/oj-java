package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-tested-devices-after-test-operations/">2960. Count Tested Devices After Test Operations</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.SIMULATION},
        difficulty = Difficulty.EASY
)
public class Solution2960 {

    @Complexity(time = "O(n)", space = "O(1)")
    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        for (int batteryPercentage : batteryPercentages) {
            if (batteryPercentage > ans) {
                ans++;
            }
        }
        return ans;
    }
}