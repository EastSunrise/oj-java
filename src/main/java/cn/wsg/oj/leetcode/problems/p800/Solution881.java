package cn.wsg.oj.leetcode.problems.p800;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.Arrays;

/**
 * 881. Boats to Save People (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/boats-to-save-people/">Boats to Save People</a>
 */
public class Solution881 implements Solution {

    /**
     * Assumes that the weights is p1,p2,...pi,...,pn after sorting and pi+pn&le;limit and
     * p{i+1}+pn&gt;limit. Whether pn choose p1 or pi doesn't have an effect on candidates of
     * p{n-1}.
     *
     * @see Complexity#TIME_N_LOG_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0, high = people.length - 1, count = 0;
        while (low < high) {
            if (people[low] + people[high] <= limit) {
                low++;
            }
            high--;
            count++;
        }
        return low == high ? count + 1 : count;
    }
}
