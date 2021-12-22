package cn.wsg.oj.leetcode.problems.interview.ch17;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.5. Find Longest Subarray LCCI (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/find-longest-subarray-lcci/">Find Longest Subarray
 * LCCI</a>
 */
public class Interview5 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, -1);
        int sum = 0, from = -1, size = 0;
        for (int i = 0; i < n; i++) {
            if (isDigit(array[i].charAt(0))) {
                sum++;
            } else {
                sum--;
            }
            Integer start = prefixSums.get(sum);
            if (start != null) {
                // a subarray of array[start+1,i]
                if (i - start > size) {
                    size = i - start;
                    from = start;
                }
            } else {
                prefixSums.put(sum, i);
            }
        }
        if (size == 0) {
            return new String[0];
        }
        return Arrays.copyOfRange(array, from + 1, from + size + 1);
    }
}
