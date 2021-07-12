package wsg.oj.java.leetcode.problems.p100;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 179. Largest Number (Medium)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/largest-number/">Largest Number</a>
 * @since 2021-07-12
 */
class Solution179 implements Solution {

    /**
     * Sorts the numbers in lexicographical order: max(str(num1)+str(num2), str(num2)+str(num1)).
     *
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String largestNumber(int[] nums) {
        boolean positive = false;
        for (int num : nums) {
            if (num > 0) {
                positive = true;
                break;
            }
        }
        if (!positive) {
            // all zeros
            return "0";
        }
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o2.compareTo(o1);
            }
            return (o2 + o1).compareTo(o1 + o2);
        });
        StringBuilder res = new StringBuilder();
        for (String s : arr) {
            res.append(s);
        }
        return res.toString();
    }
}
