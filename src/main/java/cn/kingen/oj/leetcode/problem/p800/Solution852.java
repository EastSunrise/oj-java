package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/peak-index-in-a-mountain-array/">852. Peak Index in a Mountain Array</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution162
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1095
 * @see cn.kingen.oj.leetcode.problem.p1600.Solution1671
 */
@Question(
        tags = {Tag.ARRAY, Tag.BINARY_SEARCH},
        difficulty = Difficulty.MEDIUM
)
public class Solution852 {

    @Complexity(time = "O(log(n))", space = "O(1)")
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}