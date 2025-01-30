package cn.kingen.oj.leetcode.problem.p300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-arrays-ii/">350. Intersection of Two Arrays II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p300.Solution349
 * @see cn.kingen.oj.leetcode.problem.p1000.Solution1002
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2215
 * @see cn.kingen.oj.leetcode.problem.p2100.Solution2143
 * @see cn.kingen.oj.leetcode.problem.p2200.Solution2248
 * @see cn.kingen.oj.leetcode.problem.p2500.Solution2540
 */
@Question(
    tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.TWO_POINTERS, Tag.BINARY_SEARCH, Tag.SORTING},
    difficulty = Difficulty.EASY
)
public class Solution350 {

    @Complexity(time = "O(m+n)", space = "O(n)")
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>(16);
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int size = 0;
        for (int num : nums2) {
            int cnt = freq.getOrDefault(num, 0);
            if (cnt > 0) {
                ans[size++] = num;
                freq.put(num, cnt - 1);
            }
        }
        return Arrays.copyOf(ans, size);
    }
}