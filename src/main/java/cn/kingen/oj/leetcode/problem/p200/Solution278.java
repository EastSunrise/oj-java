package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.*;

/**
 * <a href="https://leetcode.cn/problems/first-bad-version/">278. First Bad Version</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution34
 * @see cn.kingen.oj.leetcode.problem.p0.Solution35
 * @see cn.kingen.oj.leetcode.problem.p300.Solution374
 */
@Question(
        tags = {Tag.BINARY_SEARCH, Tag.INTERACTIVE},
        difficulty = Difficulty.EASY
)
public class Solution278 extends VersionControl {

    @Complexity(time = "O(log{n})", space = "O(1)")
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}