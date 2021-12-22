package cn.wsg.oj.leetcode.problems.interview.ch8;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 面试题 8.4. Power Set LCCI (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/power-set-lcci/">Power Set LCCI</a>
 */
public class Interview4 implements Solution {

    /**
     * @see #DFS
     * @see Complexity#TIME_2_N
     * @see Complexity#SPACE_2_N
     */
    public List<List<Integer>> subsets(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        int size = 0;
        for (int num : nums) {
            if (unique.add(num)) {
                nums[size++] = num;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<>(size), size - 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> tmp, int i) {
        if (i < 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        dfs(res, nums, tmp, i - 1);
        tmp.add(nums[i]);
        dfs(res, nums, tmp, i - 1);
        tmp.remove(tmp.size() - 1);
    }
}
