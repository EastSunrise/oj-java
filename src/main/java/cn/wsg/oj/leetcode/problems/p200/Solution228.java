package cn.wsg.oj.leetcode.problems.p200;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p300.Solution352;
import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges (Easy)
 *
 * @author Kingen
 * @see Solution163
 * @see Solution352
 * @see <a href="https://leetcode-cn.com/problems/summary-ranges/">Summary Ranges</a>
 */
public class Solution228 implements Solution {

    /**
     * @complexity S=O(L), L=the numbers of not-overlapping ranges
     * @see Complexity#TIME_N
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
