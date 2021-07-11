package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 90. Subsets II (Medium)
 *
 * @author Kingen
 * @see Solution78
 * @see <a href="https://leetcode-cn.com/problems/subsets-ii/">Subsets II</a>
 * @since 2021-07-11
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
     * @param temp chosen numbers from [i+1,length)
     * @param i    the first index of a distinct number to be chosen or not
     */
    private void subsetsWithDup(List<List<Integer>> res, int[] nums, List<Integer> temp, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        int j = i + 1, val = nums[i];
        while (j < nums.length && nums[j] == val) {
            j++;
        }
        // without this value
        subsetsWithDup(res, nums, temp, j);
        for (int k = i; k < j; k++) {
            // with this value of k-i+1 numbers
            temp.add(val);
            subsetsWithDup(res, nums, temp, j);
        }
        // restore
        for (int k = i; k < j; k++) {
            temp.remove(temp.size() - 1);
        }
    }
}
