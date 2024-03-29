package cn.wsg.oj.leetcode.problems.p300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II (Easy)
 *
 * @author Kingen
 * @see Solution349
 * @see Solution1002
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/">Intersection of
 * Two Arrays II</a>
 */
public class Solution350 implements Solution {

    /**
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_M_PLUS_N
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> counts = new HashMap<>(16);
        for (int num1 : nums1) {
            counts.put(num1, counts.getOrDefault(num1, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int num2 : nums2) {
            int count = counts.getOrDefault(num2, 0);
            if (count > 0) {
                res.add(num2);
                counts.put(num2, count - 1);
            }
        }
        int[] arr = new int[res.size()];
        int i = 0;
        for (int val : res) {
            arr[i++] = val;
        }
        return arr;
    }
}
