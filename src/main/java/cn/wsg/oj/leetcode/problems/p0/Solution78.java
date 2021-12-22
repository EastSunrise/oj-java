package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p700.Solution784;
import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets (Medium)
 *
 * @author Kingen
 * @see Solution90
 * @see Solution320
 * @see Solution784
 * @see <a href="https://leetcode-cn.com/problems/subsets/">Subsets</a>
 */
public class Solution78 implements Solution {

    /**
     * @see #BACKTRACKING
     * @see Complexity#TIME_2_N
     * @see Complexity#SPACE_2_N
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, nums, new ArrayList<>(), nums.length - 1);
        return res;
    }

    /**
     * @param tmp chosen numbers from [i+1,length)
     * @param i   the index of the number to be chosen or not
     */
    private void subsets(List<List<Integer>> res, int[] nums, List<Integer> tmp, int i) {
        if (i < 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        subsets(res, nums, tmp, i - 1);
        tmp.add(nums[i]);
        subsets(res, nums, tmp, i - 1);
        tmp.remove(tmp.size() - 1);
    }
}
