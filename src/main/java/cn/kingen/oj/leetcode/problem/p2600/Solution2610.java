package cn.kingen.oj.leetcode.problem.p2600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/convert-an-array-into-a-2d-array-with-conditions/">2610. Convert an Array Into a 2D Array With Conditions</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.MEDIUM,
        date = "2025-03-19"
)
public class Solution2610 {

    @Complexity(time = "O(n)", space = "O(n)")
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> rows = new HashMap<>();
        for (int num : nums) {
            int row = rows.getOrDefault(num, 0);
            while (ans.size() <= row) {
                ans.add(new ArrayList<>());
            }
            ans.get(row).add(num);
            rows.put(num, row + 1);
        }
        return ans;
    }
}