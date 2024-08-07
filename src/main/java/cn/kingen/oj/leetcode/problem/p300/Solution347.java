package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashMap;
import java.util.Map;

import static cn.kingen.oj.leetcode.util.ArrayUtils.findKthSmallest;

/**
 * <a href="https://leetcode.cn/problems/top-k-frequent-elements/">347. Top K Frequent Elements</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p100.Solution192
 * @see cn.kingen.oj.leetcode.problem.p200.Solution215
 * @see cn.kingen.oj.leetcode.problem.p400.Solution451
 * @see cn.kingen.oj.leetcode.problem.p600.Solution659
 * @see cn.kingen.oj.leetcode.problem.p600.Solution692
 * @see cn.kingen.oj.leetcode.problem.p900.Solution973
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.DIVIDE_AND_CONQUER, Tag.BUCKET_SORT, Tag.COUNTING, Tag.QUICKSELECT, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
        difficulty = Difficulty.MEDIUM
)
public class Solution347 {

    @Complexity(time = "O(n)", space = "O(n)")
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>(16);
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int size = counts.size();
        int[] values = new int[size];
        int i = 0;
        for (int value : counts.values()) {
            values[i++] = value;
        }
        int kthLargest = findKthSmallest(values, size - k + 1);

        int[] ans = new int[k];
        i = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() >= kthLargest) {
                ans[i++] = entry.getKey();
            }
        }
        return ans;
    }
}