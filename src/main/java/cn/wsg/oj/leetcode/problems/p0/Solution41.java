package cn.wsg.oj.leetcode.problems.p0;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p200.Solution268;
import cn.wsg.oj.leetcode.problems.p200.Solution287;
import cn.wsg.oj.leetcode.problems.p400.Solution448;

/**
 * 41. First Missing Positive (HARD)
 *
 * @author Kingen
 * @see Solution268
 * @see Solution287
 * @see Solution448
 * @see Solution765
 * @see <a href="https://leetcode-cn.com/problems/first-missing-positive/">First Missing
 * Positive</a>
 */
public class Solution41 implements Solution {

    /**
     * Rearranges the array to make nums[i]=i+1 if the array contains i+1 or nums[i]=0 if not.
     *
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (true) {
                if (num <= 0 || num > n) {
                    nums[i] = 0;
                    break;
                }
                if (num == i + 1) {
                    break;
                }
                if (nums[num - 1] == num) {
                    nums[i] = 0;
                    break;
                }
                int tmp = nums[num - 1];
                nums[num - 1] = num;
                num = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
