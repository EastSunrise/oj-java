package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution216;
import cn.wsg.oj.leetcode.problems.p300.Solution377;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum (Medium)
 *
 * @author Kingen
 * @see Solution17
 * @see Solution40
 * @see Solution77
 * @see Solution216
 * @see Solution254
 * @see Solution377
 * @see <a href="https://leetcode-cn.com/problems/combination-sum/">Combination Sum</a>
 */
public class Solution39 implements Solution {

    /**
     * Sorts the array before backtracking to avoid duplicate results and invalid branches.
     *
     * @see #BACKTRACKING
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }

    /**
     * @param res    the whole result
     * @param chosen list of all chosen elements
     * @param target the left target after subtracting the elements chosen in {@code chosen}
     * @param start  the start index of left elements to be chosen
     */
    private void combinationSum(int[] candidates, List<List<Integer>> res, List<Integer> chosen,
        int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(chosen));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                // since the array is sorted, the left elements are ignored
                break;
            }
            chosen.add(candidates[i]);
            combinationSum(candidates, res, chosen, target - candidates[i], i);
            chosen.remove(chosen.size() - 1);
        }
    }
}
