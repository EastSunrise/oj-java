package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.List;
import java.util.Map;

import static cn.kingen.oj.leetcode.util.ArrayUtils.invertedIndex;

/**
 * <a href="https://leetcode.cn/problems/find-the-longest-equal-subarray/">2831. Find the Longest Equal Subarray</a>
 *
 * @author Kingen
 */
@Question(
        tags = {
                Tag.ARRAY, Tag.HASH_TABLE, Tag.BINARY_SEARCH, Tag.SLIDING_WINDOW
        },
        difficulty = Difficulty.MEDIUM
)
public class Solution2831 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int ans = 1;
        Map<Integer, List<Integer>> map = invertedIndex(nums);
        for (List<Integer> indices : map.values()) {
            for (int i = 0, j = 0, size = indices.size(); i < size; i++) {
                while (j < size && (indices.get(j) - indices.get(i)) - (j - i) <= k) {
                    j++;
                }
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }
}