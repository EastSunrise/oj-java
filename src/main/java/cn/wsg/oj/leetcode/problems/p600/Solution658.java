package cn.wsg.oj.leetcode.problems.p600;

import cn.wsg.oj.Complexity;
import cn.wsg.oj.leetcode.problems.base.Solution;
import cn.wsg.oj.leetcode.problems.p300.Solution374;
import cn.wsg.oj.leetcode.problems.p300.Solution375;
import java.util.ArrayList;
import java.util.List;

/**
 * 658. Find K Closest Elements (MEDIUM)
 *
 * @author Kingen
 * @see Solution374
 * @see Solution375
 * @see Solution719
 * @see <a href="https://leetcode-cn.com/problems/find-k-closest-elements/">Find K Closest
 * Elements</a>
 */
public class Solution658 implements Solution {

    /**
     * @see Complexity#TIME_N
     * @see Complexity#SPACE_CONSTANT
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
