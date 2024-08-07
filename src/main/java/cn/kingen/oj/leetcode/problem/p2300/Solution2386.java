package cn.kingen.oj.leetcode.problem.p2300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/find-the-k-sum-of-an-array/">2386. Find the K-Sum of an Array</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.HARD
)
public class Solution2386 {

    @Complexity(time = "O(nlogn+klogk)", space = "O(k)")
    public long kSum(int[] nums, int k) {
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num >= 0) {
                max += num;
            } else {
                nums[i] = -nums[i];
            }
        }
        Arrays.sort(nums);

        PriorityQueue<long[]> heap = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        heap.add(new long[]{0, 0});
        while (--k > 0) {
            long[] t = heap.remove();
            int i = (int) t[1];
            if (i < nums.length) {
                long sum = t[0] + nums[i];
                heap.add(new long[]{sum, i + 1});
                if (i > 0) {
                    heap.add(new long[]{sum - nums[i - 1], i + 1});
                }
            }
        }
        return max - heap.element()[0];
    }
}