package wsg.oj.java.leetcode.problems.p1300;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 1389. Create Target Array in the Given Order (EASY)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/create-target-array-in-the-given-order/">Create
 * Target Array in the Given Order</a>
 * @since 2021-07-27
 */
public class Solution1389 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_NN
     * @see wsg.oj.java.Complexity#SPACE_N
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
