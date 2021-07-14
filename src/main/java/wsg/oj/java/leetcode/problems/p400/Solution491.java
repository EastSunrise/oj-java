package wsg.oj.java.leetcode.problems.p400;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 491. Increasing Subsequences (Medium)
 *
 * @author Kingen
 * @see Solution646
 * @see <a href="https://leetcode-cn.com/problems/increasing-subsequences/">Increasing
 * Subsequences</a>
 * @since 2021-07-09
 */
class Solution491 implements Solution {

    /**
     * @complexity T=O(n*2^n)
     * @complexity S=O(n)
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findSubsequences(res, nums, new ArrayList<>(), 0, Integer.MAX_VALUE);
        return res;
    }

    private void findSubsequences(List<List<Integer>> res, int[] nums, List<Integer> tmp,
        int idx, int last) {
        if (idx == nums.length) {
            if (tmp.size() > 1) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        // not chosen
        if (nums[idx] != last) {
            findSubsequences(res, nums, tmp, idx + 1, last);
        }
        if (tmp.isEmpty() || nums[idx] >= tmp.get(tmp.size() - 1)) {
            tmp.add(nums[idx]);
            findSubsequences(res, nums, tmp, idx + 1, nums[idx]);
            tmp.remove(tmp.size() - 1);
        }
    }
}
