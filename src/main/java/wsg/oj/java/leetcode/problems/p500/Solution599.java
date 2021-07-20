package wsg.oj.java.leetcode.problems.p500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p100.Solution160;

/**
 * 599. Minimum Index Sum of Two Lists (EASY)
 *
 * @author Kingen
 * @see Solution160
 * @see <a href="https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/">Minimum Index Sum
 * of Two Lists</a>
 * @since 2021-07-20
 */
public class Solution599 implements Solution {

    /**
     * @see wsg.oj.java.Complexity#TIME_M_PLUS_N
     * @see wsg.oj.java.Complexity#SPACE_N
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indices = new HashMap<>(list1.length);
        for (int i = list1.length - 1; i >= 0; i--) {
            indices.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int min = list1.length + list2.length;
        for (int j = list2.length - 1; j >= 0; j--) {
            Integer i = indices.get(list2[j]);
            if (i != null) {
                int sum = i + j;
                if (sum < min) {
                    res.clear();
                    res.add(list2[j]);
                    min = sum;
                } else if (sum == min) {
                    res.add(list2[j]);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
