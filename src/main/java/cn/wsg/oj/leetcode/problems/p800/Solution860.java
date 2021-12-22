package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 860. Lemonade Change (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/lemonade-change/">Lemonade Change</a>
 */
public class Solution860 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                count5++;
            } else {
                if (bill == 10) {
                    count10++;
                    count5--;
                } else if (count10 > 0) {
                    count10--;
                    count5--;
                } else {
                    count5 -= 3;
                }
                if (count5 < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
