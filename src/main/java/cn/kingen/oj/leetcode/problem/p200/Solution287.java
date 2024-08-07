package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/find-the-duplicate-number/">287. Find the Duplicate Number</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p0.Solution41
 * @see cn.kingen.oj.leetcode.problem.p100.Solution136
 * @see cn.kingen.oj.leetcode.problem.p100.Solution142
 * @see cn.kingen.oj.leetcode.problem.p200.Solution268
 * @see cn.kingen.oj.leetcode.problem.p600.Solution645
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.ARRAY, Tag.TWO_POINTERS, Tag.BINARY_SEARCH},
        difficulty = Difficulty.MEDIUM
)
public class Solution287 {

    /**
     * Constructs a graph including [0,n-1] as vertices and i->nums[i] contributes as an edge.
     * Then use Floyd's cycle detection algorithm to find the start of the cycle which exactly is the duplicate number.
     */
    @Complexity(time = "O(n)", space = "O(1)")
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        fast = 0;
        do {
            fast = nums[fast];
            slow = nums[slow];
        } while (fast != slow);
        return fast;
    }
}