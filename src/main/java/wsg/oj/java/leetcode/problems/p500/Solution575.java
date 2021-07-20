package wsg.oj.java.leetcode.problems.p500;

import java.util.HashSet;
import java.util.Set;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 575. Distribute Candies (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/distribute-candies/">Distribute Candies</a>
 * @since 2021-07-20
 */
class Solution575 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public int distributeCandies(int[] candyType) {
        Set<Integer> types = new HashSet<>();
        for (int type : candyType) {
            types.add(type);
        }
        return Math.min(types.size(), candyType.length / 2);
    }
}
