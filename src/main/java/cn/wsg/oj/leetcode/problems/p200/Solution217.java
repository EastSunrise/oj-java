package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate (Easy)
 *
 * @author Kingen
 * @see Solution219
 * @see Solution220
 * @see <a href="https://leetcode-cn.com/problems/contains-duplicate/">Contains Duplicate</a>
 */
public class Solution217 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
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
