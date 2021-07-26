package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 40. Combination Sum II (Medium)
 *
 * @author Kingen
 * @see Solution39
 * @see <a href="https://leetcode-cn.com/problems/combination-sum-ii/">Combination Sum II</a>
 * @since 2021-07-10
 */
public class Solution40 implements Solution {

    /**
     * Sort the array to avoid duplicate results and invalid branches. Count every distinct number
     * to avoid overusing a number.
     *
     * @see #BACKTRACKING
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] counts = new int[candidates.length];
        int len = accumulate(candidates, counts);
        List<List<Integer>> res = new ArrayList<>();
        combinationSum2(candidates, counts, len, res, new ArrayList<>(), target, 0, 0);
        return res;
    }

    /**
     * @param candidates the distinct candidates
     * @param counts     the count of each candidate
     * @param len        the number of distinct candidates
     * @param res        the whole result
     * @param chosen     list of all chosen elements
     * @param target     the left target after subtracting the elements chosen in {@code chosen}
     * @param start      the start index of left elements to be chosen
     * @param count      the count of the element at start index contained in {@code chosen}
     */
    private void combinationSum2(int[] candidates, int[] counts, int len, List<List<Integer>> res,
        List<Integer> chosen, int target, int start, int count) {
        if (target == 0) {
            res.add(new ArrayList<>(chosen));
            return;
        }
        // choose the element at start index
        if (target < candidates[start]) {
            return;
        }
        if (count < counts[start]) {
            chosen.add(candidates[start]);
            int tgt = target - candidates[start];
            combinationSum2(candidates, counts, len, res, chosen, tgt, start, count + 1);
            chosen.remove(chosen.size() - 1);
        }
        // choose elements after start index
        for (int i = start + 1; i < len; i++) {
            if (target < candidates[i]) {
                // since the array is sorted, the left elements are ignored
                return;
            }
            chosen.add(candidates[i]);
            combinationSum2(candidates, counts, len, res, chosen, target - candidates[i], i, 1);
            chosen.remove(chosen.size() - 1);
        }
    }
}
