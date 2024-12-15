package cn.kingen.oj.leetcode.problem.p1300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/reduce-array-size-to-the-half/">1338. Reduce Array Size to The Half</a>
 *
 * @author Kingen

 */
@Question(
    tags = {Tag.GREEDY, Tag.ARRAY, Tag.HASH_TABLE, Tag.SORTING, Tag.HEAP_PRIORITY_QUEUE},
    difficulty = Difficulty.MEDIUM
)
public class Solution1338 {

    @Complexity(time = "O(n*log(n))", space = "O(n)")
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.merge(num, 1, Integer::sum);
        }

        Integer[] counts = freq.values().toArray(Integer[]::new);
        Arrays.sort(counts);
        int sum = 0, half = arr.length / 2;
        for (int i = counts.length - 1; ; i--) {
            sum += counts[i];
            if (sum >= half) {
                return counts.length - i;
            }
        }
    }
}