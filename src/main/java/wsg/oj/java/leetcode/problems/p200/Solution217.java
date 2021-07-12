package wsg.oj.java.leetcode.problems.p200;

import java.util.HashSet;
import java.util.Set;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 217. Contains Duplicate (Easy)
 *
 * @author Kingen
 * @see Solution219
 * @see Solution220
 * @see <a href="https://leetcode-cn.com/problems/contains-duplicate/">Contains Duplicate</a>
 * @since 2021-07-12
 */
class Solution217 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (!unique.add(num)) {
                return true;
            }
        }
        return false;
    }
}
