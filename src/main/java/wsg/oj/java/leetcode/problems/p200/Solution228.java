package wsg.oj.java.leetcode.problems.p200;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 228. Summary Ranges (Easy)
 *
 * @author Kingen
 * @see Solution163
 * @see Solution352
 * @see <a href="https://leetcode-cn.com/problems/summary-ranges/">Summary Ranges</a>
 * @since 2021-07-13
 */
public class Solution228 implements Solution {

    /**
     * @complexity S=O(L), L=the numbers of not-overlapping ranges
     * @see wsg.oj.java.Complexity#TIME_N
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>(nums.length);
        int length = nums.length;
        int left = 0;
        while (left < length) {
            int right = left + 1;
            while (right < length && nums[right] == nums[right - 1] + 1) {
                right++;
            }
            StringBuilder builder = new StringBuilder().append(nums[left]);
            if (right > left + 1) {
                builder.append("->").append(nums[right - 1]);
            }
            res.add(builder.toString());
            left = right;
        }
        return res;
    }
}
