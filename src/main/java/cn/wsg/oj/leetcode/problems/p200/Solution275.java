package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 275. H-Index II (Medium)
 *
 * @author Kingen
 * @see Solution274
 * @see <a href="https://leetcode-cn.com/problems/h-index-ii/">H-Index II</a>
 */
public class Solution275 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int hIndex(int[] citations) {
        int len = citations.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (citations[mid] < len - mid) {
                low = mid + 1;
            } else if (citations[mid] > len - mid) {
                high = mid - 1;
            } else {
                return citations[mid];
            }
        }
        return len - low;
    }
}
