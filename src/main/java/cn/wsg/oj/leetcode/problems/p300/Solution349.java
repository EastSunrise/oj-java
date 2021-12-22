package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 349. Intersection of Two Arrays (Easy)
 *
 * @author Kingen
 * @see Solution350
 * @see Solution1213
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-arrays/">Intersection of Two
 * Arrays</a>
 */
public class Solution349 implements Solution {

    /**
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_M_PLUS_N
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int i = 0;
        for (Integer value : set1) {
            res[i++] = value;
        }
        return res;
    }
}
