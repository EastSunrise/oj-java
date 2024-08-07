package cn.kingen.oj.leetcode.problem.ch08;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/power-set-lcci/">面试题 08.04. Power Set LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.BACKTRACKING},
        difficulty = Difficulty.MEDIUM
)
public class Interview04 {

    @Complexity(time = "O(2^n)", space = "O(n)")
    public List<List<Integer>> subsets(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        int size = 0;
        for (int num : nums) {
            if (unique.add(num)) {
                nums[size++] = num;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, nums, new ArrayList<>(size), size - 1);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> tmp, int i) {
        if (i < 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        dfs(ans, nums, tmp, i - 1);
        tmp.add(nums[i]);
        dfs(ans, nums, tmp, i - 1);
        tmp.removeLast();
    }
}