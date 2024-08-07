package cn.kingen.oj.leetcode.problem.p2900;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/find-common-elements-between-two-arrays/">2956. Find Common Elements Between Two Arrays</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.EASY
)
public class Solution2956 {

    @Complexity(time = "O(m+n)", space = "O(m+n)")
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        int count1 = 0, count2 = 0;
        for (int num : nums1) {
            if (set2.contains(num)) {
                count1++;
            }
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                count2++;
            }
        }
        return new int[]{count1, count2};
    }
}