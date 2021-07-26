package wsg.oj.java.leetcode.problems.p0;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.Complexity;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 46. Permutations (Medium)
 *
 * @author Kingen
 * @see Solution31
 * @see Solution47
 * @see Solution60
 * @see Solution77
 * @see <a href="https://leetcode-cn.com/problems/permutations/">Permutations</a>
 * @since 2021-07-10
 */
public class Solution46 implements Solution {

    /**
     * @see #BACKTRACKING
     * @see Complexity#TIME_NF
     * @see Complexity#SPACE_NF
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, res, new ArrayList<>(nums.length), new boolean[nums.length]);
        return res;
    }

    /**
     * @param temp    store visited numbers
     * @param visited if a number is visited
     */
    private void permute(int[] nums, List<List<Integer>> res, List<Integer> temp,
        boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                temp.add(nums[i]);
                visited[i] = true;
                permute(nums, res, temp, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
