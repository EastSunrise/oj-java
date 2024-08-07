package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-game/">2974. Minimum Number Game</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.SORTING, Tag.SIMULATION, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.EASY
)
public class Solution2974 {

    @Complexity(time = "O(n*log{n})", space = "O(1)")
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] ans = new int[n];
        for (int i = 0; i < n; i += 2) {
            ans[i] = nums[i + 1];
            ans[i + 1] = nums[i];
        }
        return ans;
    }
}