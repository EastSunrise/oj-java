package wsg.oj.java.leetcode.problems.p300;

import java.util.HashMap;
import java.util.Map;
import wsg.oj.java.leetcode.problems.p200.Solution215;

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

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>(16);
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        int[] counts = new int[frequency.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            counts[i++] = entry.getValue();
        }
        int kthLargest = findKthLargest(counts, k);
        int[] res = new int[k];
        i = 0;
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() >= kthLargest) {
                res[i++] = entry.getKey();
            }
        }
        return res;
    }
}
