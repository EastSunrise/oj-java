package cn.wsg.oj.leetcode.problems.p500;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.HashSet;
import java.util.Set;

/**
 * 575. Distribute Candies (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/distribute-candies/">Distribute Candies</a>
 */
class Solution575 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_N
     */
    public int distributeCandies(int[] candyType) {
        Set<Integer> types = new HashSet<>();
        for (int type : candyType) {
            types.add(type);
        }
        return Math.min(types.size(), candyType.length / 2);
    }
}
