package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/sum-swap-lcci/">面试题 16.21. Sum Swap LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.BINARY_SEARCH, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Interview21 {

    @Complexity(time = "O(m+n)", space = "O(m)")
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0, sum2 = 0;
        for (int num1 : array1) {
            sum1 += num1;
        }
        for (int num2 : array2) {
            sum2 += num2;
        }
        int diff = sum1 - sum2;
        if (diff % 2 != 0) {
            return new int[0];
        }

        diff /= 2;
        Set<Integer> nums1 = new HashSet<>();
        for (int num1 : array1) {
            nums1.add(num1);
        }
        for (int num2 : array2) {
            if (nums1.contains(diff + num2)) {
                return new int[]{diff + num2, num2};
            }
        }
        return new int[0];
    }
}