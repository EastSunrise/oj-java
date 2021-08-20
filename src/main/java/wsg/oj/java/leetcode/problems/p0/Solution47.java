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
public class Solution47 implements Solution {

    /**
     * Chooses a number different from the last one every time.
     *
     * @see Complexity#TIME_NF
     * @see Complexity#SPACE_NF
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] counts = new int[n];
        int len = accumulate(nums, counts);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>(n);
        for (int num : nums) {
            tmp.add(num);
        }
        permuteUnique(res, nums, counts, len, tmp, Integer.MAX_VALUE, 0);
        return res;
    }

    private void permuteUnique(List<List<Integer>> res, int[] nums, int[] unused, int len,
        List<Integer> tmp, int prevVal, int cur) {
        if (cur == tmp.size()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < len; i++) {
            int num = nums[i], count = unused[i];
            if (num == prevVal || count == 0) {
                continue;
            }
            for (int j = 0; j < count; j++) {
                tmp.set(cur++, num);
                unused[i]--;
                permuteUnique(res, nums, unused, len, tmp, num, cur);
            }
            // restore
            cur -= count;
            unused[i] = count;
        }
    }
}
