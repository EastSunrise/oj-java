package wsg.oj.java.leetcode.problems.p700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution198;

/**
 * 740. Delete and Earn (MEDIUM)
 *
 * @author Kingen
 * @see Solution198
 * @see <a href="https://leetcode-cn.com/problems/delete-and-earn/">Delete and Earn</a>
 * @since 2021-07-27
 */
public class Solution740 implements Solution {

    /**
     * @see #DYNAMIC_PROGRAMMING
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> sums = new ArrayList<>();
        int size = 0, num = nums[0], count = 1;
        for (int j = 1; j < n; j++) {
            if (nums[j] == num) {
                count++;
            } else {
                nums[size++] = num;
                sums.add(num * count);
                num = nums[j];
                count = 1;
            }
        }
        nums[size++] = num;
        sums.add(num * count);

        int prev = 0, cur = sums.get(0), next;
        for (int i = 1; i < size; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                next = Math.max(prev + sums.get(i), cur);
            } else {
                next = cur + sums.get(i);
            }
            prev = cur;
            cur = next;
        }
        return cur;
    }
}
