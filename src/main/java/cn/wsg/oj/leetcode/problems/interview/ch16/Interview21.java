package cn.wsg.oj.leetcode.problems.interview.ch16;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 16.21. Sum Swap LCCI (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/sum-swap-lcci/">Sum Swap LCCI</a>
 */
public class Interview21 implements Solution {

    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0, sum2 = 0;
        Set<Integer> nums1 = new HashSet<>();
        for (int num1 : array1) {
            sum1 += num1;
            nums1.add(num1);
        }
        for (int num2 : array2) {
            sum2 += num2;
        }
        int difference = sum1 - sum2;
        if (difference % 2 != 0) {
            return new int[0];
        }
        difference /= 2;
        for (int num2 : array2) {
            if (nums1.contains(difference + num2)) {
                return new int[]{difference + num2, num2};
            }
        }
        return new int[0];
    }
}
