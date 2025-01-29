package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-ii/">219. Contains Duplicate II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution217
 * @see cn.kingen.oj.leetcode.problem.p200.Solution220
 */
@Question(
    tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.SLIDING_WINDOW},
    difficulty = Difficulty.EASY,
    daily = "2025-01-29"
)
public class Solution219 {

    @Complexity(time = "O(n)", space = "O(n)")
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> num2LastIndexMap = new HashMap<>(16);
        for (int i = 0; i < n; i++) {
            Integer prev = num2LastIndexMap.put(nums[i], i);
            if (prev != null && i - prev <= k) {
                return true;
            }
        }
        return false;
    }
}