package wsg.oj.java.leetcode.problems.p300;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.p200.Solution215;
import wsg.oj.java.leetcode.problems.p400.Solution451;
import wsg.oj.java.leetcode.problems.p600.Solution659;
import wsg.oj.java.leetcode.problems.p600.Solution692;
import wsg.oj.java.leetcode.problems.p900.Solution973;

/**
 * 347. Top K Frequent Elements (Medium)
 *
 * @author Kingen
 * @see Solution192
 * @see Solution215
 * @see Solution451
 * @see Solution659
 * @see Solution692
 * @see Solution973
 * @see Solution1772
 * @see <a href="https://leetcode-cn.com/problems/top-k-frequent-elements/">Top K Frequent
 * Elements</a>
 * @since 2021-07-04
 */
public class Solution347 extends Solution215 {

    /**
     * @complexity T=O(n+k)
     * @complexity S=O(u), u=the number of distinct numbers
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>(16);
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int[] values = new int[counts.size()];
        int i = 0;
        for (int value : counts.values()) {
            values[i++] = value;
        }
        int kthLargest = findKthLargest(values, k - 1);
        int[] res = new int[k];
        i = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() >= kthLargest) {
                res[i++] = entry.getKey();
            }
        }
        return res;
    }
}
