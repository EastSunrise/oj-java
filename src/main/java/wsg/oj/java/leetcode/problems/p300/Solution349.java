package wsg.oj.java.leetcode.problems.p300;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 349. Intersection of Two Arrays (Easy)
 *
 * @author Kingen
 * @see Solution350
 * @see Solution1213
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-arrays/">Intersection of Two
 * Arrays</a>
 * @since 2021-07-13
 */
class Solution349 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_M_PLUS_N
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
