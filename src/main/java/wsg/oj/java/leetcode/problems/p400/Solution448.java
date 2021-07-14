package wsg.oj.java.leetcode.problems.p400;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 448. Find All Numbers Disappeared in an Array (Easy)
 *
 * @author Kingen
 * @see Solution41
 * @see Solution442
 * @see <a href="https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/">Find
 * All Numbers Disappeared in an Array</a>
 * @since 2021-07-14
 */
class Solution448 implements Solution {

    /**
     * Rearranges numbers to satisfy that num[i]=i+1.
     *
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                int value = nums[i];
                nums[i] = 0;
                while (value != 0 && nums[value - 1] != value) {
                    int temp = nums[value - 1];
                    nums[value - 1] = value;
                    value = temp;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
