package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p0.Solution34;
import cn.wsg.oj.leetcode.problems.p0.Solution35;

/**
 * 278. First Bad Version (Easy)
 *
 * @author Kingen
 * @see Solution34
 * @see Solution35
 * @see Solution374
 * @see <a href="https://leetcode-cn.com/problems/first-bad-version/">First Bad Version</a>
 */
public class Solution278 implements Solution {

    /**
     * @see #BINARY_SEARCH
     * @see Complexity#TIME_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * The isBadVersion API is defined.
     */
    private boolean isBadVersion(int version) {
        return version >= 5;
    }
}
