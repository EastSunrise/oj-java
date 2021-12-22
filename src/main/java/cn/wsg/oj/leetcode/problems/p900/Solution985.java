package cn.wsg.oj.leetcode.problems.p900;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 985. Sum of Even Numbers After Queries (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries/">Sum of Even
 * Numbers After Queries</a>
 */
public class Solution985 implements Solution {

    /**
     * @see Complexity#TIME_M_PLUS_N
     * @see Complexity#SPACE_N
     */
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                sum += num;
            }
        }
        int[] res = new int[queries.length];
        int r = 0;
        for (int[] query : queries) {
            int idx = query[1];
            if ((nums[idx] & 1) == 0) {
                sum -= nums[idx];
            }
            nums[idx] += query[0];
            if ((nums[idx] & 1) == 0) {
                sum += nums[idx];
            }
            res[r++] = sum;
        }
        return res;
    }
}
