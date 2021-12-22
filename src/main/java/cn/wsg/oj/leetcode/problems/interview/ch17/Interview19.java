package cn.wsg.oj.leetcode.problems.interview.ch17;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;

/**
 * 面试题 17.19. Missing Two LCCI (HARD)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/missing-two-lcci/">Missing Two LCCI</a>
 */
public class Interview19 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
     */
    public int[] missingTwo(int[] nums) {
        int n = nums.length;
        boolean hasN1p = false, hasN2p = false;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] != i + 1) {
                if (nums[i] == n + 1) {
                    hasN1p = true;
                    nums[i] = 0;
                    break;
                }
                if (nums[i] == n + 2) {
                    hasN2p = true;
                    nums[i] = 0;
                    break;
                }
                // swap
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        int[] res = new int[2];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                res[j++] = i + 1;
            }
        }
        if (!hasN1p) {
            res[j++] = n + 1;
        }
        if (!hasN2p) {
            res[j] = n + 2;
        }
        return res;
    }
}
