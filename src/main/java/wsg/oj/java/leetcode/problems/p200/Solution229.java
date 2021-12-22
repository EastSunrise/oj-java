package wsg.oj.java.leetcode.problems.p200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution169;

/**
 * 229. Majority Element II (Medium)
 *
 * @author Kingen
 * @see Solution169
 * @see Solution1150
 * @see <a href="https://leetcode-cn.com/problems/majority-element-ii/">Majority Element II</a>
 * @since 2021-07-13
 */
public class Solution229 implements Solution {

    public List<Integer> majorityElement(int[] nums) {
        return majorityElements(nums, 3);
    }

    /**
     * Finds elements that appear more than [n/m] times.
     * <p>
     * Moore Voting: if x is a majority that appears more than [n/m] times, it's still a majority
     * after removing m different elements from the array.
     *
     * @see wsg.oj.java.Complexity#TIME_MN
     * @see wsg.oj.java.Complexity#SPACE_M
     */
    private List<Integer> majorityElements(int[] nums, int m) {
        // candidates of majorities
        Map<Integer, Integer> majorities = new HashMap<>(m - 1);
        for (int num : nums) {
            Integer cnt = majorities.get(num);
            if (cnt != null) {
                // count++ if exists
                majorities.put(num, cnt + 1);
                continue;
            }
            if (majorities.size() < m - 1) {
                // add a new majority
                majorities.put(num, 1);
                continue;
            }
            // nullify m different numbers
            Iterator<Map.Entry<Integer, Integer>> iterator = majorities.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() == 1) {
                    iterator.remove();
                } else {
                    majorities.put(entry.getKey(), entry.getValue() - 1);
                }
            }
        }
        // check whether a candidate is truly a majority
        List<Integer> res = new ArrayList<>();
        int target = nums.length / m;
        for (int majority : majorities.keySet()) {
            int count = 0;
            for (int num : nums) {
                if (num == majority) {
                    count++;
                }
            }
            if (count > target) {
                res.add(majority);
            }
        }
        return res;
    }
}
