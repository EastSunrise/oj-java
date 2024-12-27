package cn.kingen.oj.leetcode.problem.p3100;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-occurrences-of-an-element-in-an-array/">3159. Find Occurrences of an Element in an Array</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.MEDIUM,
        daily = "2024-12-27"
)
public class Solution3159 {

    @Complexity(time = "O(n+m)", space = "O(n)")
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = nums.length, m = queries.length;
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == x) {
                indices.add(i);
            }
        }

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = queries[i] <= indices.size() ? indices.get(queries[i] - 1) : -1;
        }
        return ans;
    }
}