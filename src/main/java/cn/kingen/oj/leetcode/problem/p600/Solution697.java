package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/degree-of-an-array/">697. Degree of an Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution53
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.EASY
)
public class Solution697 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int findShortestSubArray(int[] nums) {
        // value: count of the key, first index, last index
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] value = map.get(nums[i]);
            if (value == null) {
                map.put(nums[i], new int[]{1, i, i});
            } else {
                value[0]++;
                value[2] = i;
            }
        }
        int degree = 0, ans = nums.length;
        for (int[] value : map.values()) {
            if (value[0] > degree) {
                degree = value[0];
                ans = value[2] - value[1];
            } else if (value[0] == degree) {
                ans = Math.min(value[2] - value[1], ans);
            }
        }
        return ans + 1;
    }
}