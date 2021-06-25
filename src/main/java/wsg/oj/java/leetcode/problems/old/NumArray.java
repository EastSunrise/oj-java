package wsg.oj.java.leetcode.problems.old;

/**
 * @author Kingen
 */
public class NumArray {

    private final int[] sum;
    private final int len;

    public NumArray(int[] nums) {
        len = nums.length;
        sum = new int[len];
        if (len > 0) {
            sum[0] = nums[0];
            for (int i = 1; i < len; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i <= j && j < len) {
            return i == 0 ? sum[j] : (i > 0 ? sum[j] - sum[i - 1] : -1);
        }
        return -1;
    }
}
