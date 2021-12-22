package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 274. H-Index (Medium)
 *
 * @author Kingen
 * @see Solution275
 * @see <a href="https://leetcode-cn.com/problems/h-index/">H-Index</a>
 */
public class Solution274 implements Solution {

    /**
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_CONSTANT
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
