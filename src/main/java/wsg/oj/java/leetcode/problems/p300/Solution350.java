package wsg.oj.java.leetcode.problems.p300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 350. Intersection of Two Arrays II (Easy)
 *
 * @author Kingen
 * @see Solution349
 * @see Solution1002
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/">Intersection of
 * Two Arrays II</a>
 * @since 2021-07-13
 */
class Solution350 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_M_PLUS_N
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts1 = new HashMap<>(16);
        for (int num1 : nums1) {
            counts1.put(num1, counts1.getOrDefault(num1, 0) + 1);
        }
        Map<Integer, Integer> counts2 = new HashMap<>(16);
        for (int num2 : nums2) {
            counts2.put(num2, counts2.getOrDefault(num2, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        if (counts1.size() > counts2.size()) {
            Map<Integer, Integer> tmp = counts1;
            counts1 = counts2;
            counts2 = tmp;
        }
        for (Map.Entry<Integer, Integer> entry : counts1.entrySet()) {
            int key = entry.getKey();
            int count = Math.min(counts2.getOrDefault(key, 0), entry.getValue());
            for (int i = 0; i < count; i++) {
                res.add(key);
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
