package cn.wsg.oj.leetcode.problems.p1400;

import cn.wsg.oj.leetcode.problems.base.Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * 1424. Diagonal Traverse II (MEDIUM)
 *
 * @author Kingen
 * @see <a href="https://leetcode-cn.com/problems/diagonal-traverse-ii/">Diagonal Traverse II</a>
 */
public class Solution1424 implements Solution {

    /**
     * @complexity T=O(N), N=the total count of numbers
     * @complexity S=O(N)
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int m = nums.size();
        int len = 0, total = 0;
        for (int i = 0; i < m; i++) {
            int size = nums.get(i).size();
            total += size;
            len = Math.max(len, size + i);
        }
        List<List<Integer>> lines = new ArrayList<>(len);
        for (int k = 0; k < len; k++) {
            lines.add(new ArrayList<>());
        }
        for (int i = m - 1; i >= 0; i--) {
            List<Integer> row = nums.get(i);
            for (int j = 0; j < row.size(); j++) {
                lines.get(i + j).add(row.get(j));
            }
        }
        int[] res = new int[total];
        int k = 0;
        for (List<Integer> line : lines) {
            for (int num : line) {
                res[k++] = num;
            }
        }
        return res;
    }
}
