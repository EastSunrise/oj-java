package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pairs-with-sum-lcci/">面试题 16.24. Pairs With Sum LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.TWO_POINTERS, Tag.COUNTING, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Interview24 {

    @Complexity(time = "O(n*log{n})", space = "O(1)")
    public List<List<Integer>> pairSums(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                ans.add(Arrays.asList(nums[i], nums[j]));
                i++;
                j--;
            }
        }
        return ans;
    }
}