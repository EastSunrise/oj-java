package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II (Medium)
 *
 * @author Kingen
 * @see Solution78
 * @see <a href="https://leetcode-cn.com/problems/subsets-ii/">Subsets II</a>
 */
class Solution90 implements Solution {

    /**
     * Sorts the array and choose the same number only one time.
     *
     * @complexity T=O(s), s=sum(counts(x)), counts(x)=the count of the number x
     * @complexity S=O(ns)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDup(res, nums, new ArrayList<>(), 0);
        return res;
    }

    /**
     * @param tmp chosen numbers from [i+1,length)
     * @param i   the first index of next distinct number to be chosen or not
     */
    private void subsetsWithDup(List<List<Integer>> res, int[] nums, List<Integer> tmp, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        int j = i + 1, val = nums[i];
        while (j < nums.length && nums[j] == val) {
            j++;
        }
        // without this value
        subsetsWithDup(res, nums, tmp, j);
        for (int k = i; k < j; k++) {
            // choose this value of k-i+1 numbers
            tmp.add(val);
            subsetsWithDup(res, nums, tmp, j);
        }
        // restore
        for (int k = i; k < j; k++) {
            tmp.remove(tmp.size() - 1);
        }
    }
}
