package wsg.oj.java.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Kingen
 */
public class KthLargest {

    private int k;
    private Integer[] data;

    private KthLargest(int k, int[] nums) {
        this.k = k;
        data = new Integer[k];
        int len = Math.min(nums.length, k);
        for (int i = 0; i < len; i++)
            data[i] = nums[i];
        Arrays.sort(data, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == null)
                    return -1;
                else if (o2 == null)
                    return 1;
                else
                    return o1.compareTo(o2);
            }
        });
    }

    public int add(int val) {
        int i = -1;
        while (++i < k)
            if (data[i] == null || data[i] < val) {
                if (k - 1 - i >= 0)
                    System.arraycopy(data, i, data, i + 1, k - 1 - i);
                data[i] = val;
                break;
            }
        return data[k - 1];
    }
}
