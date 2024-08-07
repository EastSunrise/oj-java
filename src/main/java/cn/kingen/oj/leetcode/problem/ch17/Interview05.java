package cn.kingen.oj.leetcode.problem.ch17;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-longest-subarray-lcci/">面试题 17.05. Find Longest Subarray LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.PREFIX_SUM},
        difficulty = Difficulty.MEDIUM
)
public class Interview05 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, -1);
        int diff = 0, fromEx = -1, size = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(array[i].charAt(0))) {
                diff++;
            } else {
                diff--;
            }
            Integer start = prefix.get(diff);
            if (start != null) { // found a subarray from start+1 to i
                if (i - start > size) {
                    size = i - start;
                    fromEx = start;
                }
            } else {
                prefix.put(diff, i);
            }
        }
        if (size == 0) {
            return new String[0];
        }
        return Arrays.copyOfRange(array, fromEx + 1, fromEx + 1 + size);
    }
}