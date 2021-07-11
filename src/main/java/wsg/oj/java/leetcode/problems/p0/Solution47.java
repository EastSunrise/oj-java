package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import wsg.oj.java.Complexity;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 47. Permutations II (Medium)
 *
 * @author Kingen
 * @see Solution31
 * @see Solution46
 * @see Solution267
 * @see Solution996
 * @see <a href="https://leetcode-cn.com/problems/permutations-ii/">Permutations II</a>
 * @since 2021-07-11
 */
class Solution47 implements Solution {

    /**
     * Chooses a number different from the last one every time.
     *
     * @see Complexity#TIME_NF
     * @see Complexity#SPACE_NF
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] counts = new int[nums.length];
        int len = accumulate(nums, counts);
        List<List<Integer>> res = new ArrayList<>();
        permuteUnique(res, nums, nums.length, counts, len, new ArrayList<>(nums.length), 11);
        return res;
    }

    private void permuteUnique(List<List<Integer>> res, int[] nums, int total,
        int[] unused, int len, List<Integer> tmp, int last) {
        if (tmp.size() == total) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < len; i++) {
            int num = nums[i], count = unused[i];
            if (num == last || count == 0) {
                continue;
            }
            for (int j = 0; j < count; j++) {
                tmp.add(num);
                unused[i]--;
                permuteUnique(res, nums, total, unused, len, tmp, num);
            }
            for (int j = 0; j < count; j++) {
                tmp.remove(tmp.size() - 1);
            }
            unused[i] = count;
        }
    }
}
