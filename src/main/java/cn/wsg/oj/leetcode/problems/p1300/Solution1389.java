package cn.wsg.oj.leetcode.problems.p1300;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 1389. Create Target Array in the Given Order (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/create-target-array-in-the-given-order/">Create
 * Target Array in the Given Order</a>
 */
public class Solution1389 implements Solution {

    /**
     * @see Complexity#TIME_NN
     * @see Complexity#SPACE_N
     */
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (index[j] >= index[i]) {
                    index[j]++;
                }
            }
        }
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[index[i]] = nums[i];
        }
        return target;
    }

    public int[] createTargetArray2(int[] nums, int[] index) {
        int n = nums.length;
        List<Integer> target = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            target.add(index[i], nums[i]);
        }
        return toArray(target);
    }
}
