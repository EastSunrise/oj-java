package cn.kingen.oj.leetcode.problem.p2800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.List;
import java.util.Map;

import static cn.kingen.oj.leetcode.util.ArrayUtils.invertedIndex;

/**
 * <a href="https://leetcode.cn/problems/minimum-seconds-to-equalize-a-circular-array/">2808. Minimum Seconds to Equalize a Circular Array</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.MEDIUM
)
public class Solution2808 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        int min = n;
        Map<Integer, List<Integer>> map = invertedIndex(nums);
        for (List<Integer> indices : map.values()) {
            int max = indices.getFirst() + n - indices.getLast();
            for (int j = indices.size() - 1; j > 0; j--) {
                max = Math.max(max, indices.get(j) - indices.get(j - 1));
            }
            min = Math.min(min, max / 2);
        }
        return min;
    }
}