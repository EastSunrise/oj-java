package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/falling-squares/">699. Falling Squares</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Solution218
 */
@Question(
        tags = {Tag.SEGMENT_TREE, Tag.ARRAY, Tag.ORDERED_SET},
        difficulty = Difficulty.HARD
)
public class Solution699 {

    @Complexity(time = "O(n*log{n})", space = "O(n)")
    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> ans = new ArrayList<>(n);
        TreeMap<Integer, Integer> heights = new TreeMap<>();
        heights.put(0, 0);
        int maxHeight = 0;
        for (int[] pos : positions) {
            int left = pos[0], right = pos[0] + pos[1];
            int leftHeight = heights.floorEntry(left).getValue();
            int rightHeight = heights.floorEntry(right).getValue();
            var subMap = heights.subMap(left, right);
            int height = leftHeight;
            for (int value : subMap.values()) {
                height = Math.max(height, value);
            }
            Iterator<Integer> iterator = subMap.keySet().iterator();
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
            height += pos[1];
            heights.put(left, height);
            heights.put(right, rightHeight);
            maxHeight = Math.max(maxHeight, height);
            ans.add(maxHeight);
        }
        return ans;
    }
}