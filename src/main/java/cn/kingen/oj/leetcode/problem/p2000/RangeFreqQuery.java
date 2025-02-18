package cn.kingen.oj.leetcode.problem.p2000;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/range-frequency-queries/">2080. Range Frequency Queries</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.DESIGN, Tag.SEGMENT_TREE, Tag.ARRAY, Tag.HASH_TABLE, Tag.BINARY_SEARCH},
        difficulty = Difficulty.MEDIUM,
        date = "2025-02-18"
)
public class RangeFreqQuery {

    private final Map<Integer, List<Integer>> num2Indices;

    public RangeFreqQuery(int[] arr) {
        this.num2Indices = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            num2Indices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> indices = num2Indices.get(value);
        if (indices == null) {
            return 0;
        }
        int i = Collections.binarySearch(indices, left);
        if (i < 0) {
            i = -i - 1;
        }
        int j = Collections.binarySearch(indices, right);
        if (j < 0) {
            j = -j - 2;
        }
        return j - i + 1;
    }
}