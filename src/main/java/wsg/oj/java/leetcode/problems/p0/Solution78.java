package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 78. Subsets (Medium)
 *
 * @author Kingen
 * @see Solution90
 * @see Solution320
 * @see Solution784
 * @see <a href="https://leetcode-cn.com/problems/subsets/">Subsets</a>
 * @since 2021-07-11
 */
class Solution78 implements Solution {

    /**
     * @see #BACKTRACKING
     * @see wsg.oj.java.Complexity#TIME_2_N
     * @see wsg.oj.java.Complexity#SPACE_2_N
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, nums, new ArrayList<>(), nums.length - 1);
        return res;
    }

    /**
     * @param temp chosen numbers from [i+1,length)
     * @param i    the index of the number to be chosen or not
     */
    private void subsets(List<List<Integer>> res, int[] nums, List<Integer> temp, int i) {
        if (i < 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        subsets(res, nums, temp, i - 1);
        temp.add(nums[i]);
        subsets(res, nums, temp, i - 1);
        temp.remove(temp.size() - 1);
    }
}
