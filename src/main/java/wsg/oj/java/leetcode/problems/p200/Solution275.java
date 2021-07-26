package wsg.oj.java.leetcode.problems.p200;

import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 275. H-Index II (Medium)
 *
 * @author Kingen
 * @see Solution274
 * @see <a href="https://leetcode-cn.com/problems/h-index-ii/">H-Index II</a>
 * @since 2021-07-13
 */
public class Solution275 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see wsg.oj.java.Complexity#TIME_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
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
