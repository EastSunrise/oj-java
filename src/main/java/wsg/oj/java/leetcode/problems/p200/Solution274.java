package wsg.oj.java.leetcode.problems.p200;

import java.util.Arrays;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 274. H-Index (Medium)
 *
 * @author Kingen
 * @see Solution275
 * @see <a href="https://leetcode-cn.com/problems/h-index/">H-Index</a>
 * @since 2021-07-13
 */
public class Solution274 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N_LOG_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     * @see <a href="https://en.wikipedia.org/wiki/H-index>h-index</a>
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length - 1, h = 0;
        for (int i = len; i >= 0; i--) {
            if (citations[i] > len - i) {
                h++;
            }
        }
        return h;
    }
}
