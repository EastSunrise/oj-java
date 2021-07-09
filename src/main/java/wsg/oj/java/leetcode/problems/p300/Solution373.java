package wsg.oj.java.leetcode.problems.p300;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 373. Find K Pairs with Smallest Sums (Medium)
 *
 * @author Kingen
 * @see Solution378
 * @see Solution719
 * @see <a href="https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/">Find K Pairs
 * with Smallest Sums</a>
 * @since 2021-07-04
 */
class Solution373 implements Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(
            Comparator.comparing(list -> list.get(0) + list.get(1)));
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                queue.add(List.of(num1, num2));
            }
        }
        List<List<Integer>> res = new ArrayList<>(Math.min(k, nums1.length * nums2.length));
        while (k-- > 0 && !queue.isEmpty()) {
            res.add(queue.remove());
        }
        return res;
    }
}
