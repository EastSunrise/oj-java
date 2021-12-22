package cn.wsg.oj.leetcode.problems.p400;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array (Medium)
 *
 * @author Kingen
 * @see Solution448
 * @see <a href="https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/">Find All
 * Duplicates in an Array</a>
 */
class Solution442 implements Solution {

    /**
     * Swaps numbers to make the number at the index i equal to i: num[i]=i.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i]--;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (num > i && nums[num] != num) {
                nums[i] = nums[num];
                nums[num] = num;
                num = nums[i];
            }
            if (num == i) {
                continue;
            }
            if (num < i) {
                if (nums[num] != -1) {
                    res.add(num + 1);
                } else {
                    nums[num] = num;
                }
            } else {
                res.add(num + 1);
            }
            nums[i] = -1;
        }
        return res;
    }
}
