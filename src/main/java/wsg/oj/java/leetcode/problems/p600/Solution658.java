package wsg.oj.java.leetcode.problems.p600;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p300.Solution374;
import wsg.oj.java.leetcode.problems.p300.Solution375;

/**
 * 658. Find K Closest Elements (MEDIUM)
 *
 * @author Kingen
 * @see Solution374
 * @see Solution375
 * @see Solution719
 * @see <a href="https://leetcode-cn.com/problems/find-k-closest-elements/">Find K Closest
 * Elements</a>
 * @since 2021-07-23
 */
public class Solution658 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_N
     * @see wsg.oj.java.Complexity#SPACE_CONSTANT
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (k++ < n) {
            int a = Math.abs(arr[left] - x), b = Math.abs(arr[right] - x);
            if (a <= b) {
                right--;
            } else {
                left++;
            }
        }
        List<Integer> res = new ArrayList<>(right - left + 1);
        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
