package wsg.oj.java.leetcode.problems.p300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 398. Random Pick Index (Medium)
 *
 * @author Kingen
 * @see Solution382
 * @see Solution710
 * @see Solution528
 * @see <a href="https://leetcode-cn.com/problems/random-pick-index/">Random Pick Index</a>
 * @since 2021-07-06
 */
class Solution398 implements Solution {

    private static class Solution {

        private final Map<Integer, List<Integer>> values = new HashMap<>(16);
        private final Random random = new Random();

        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                values.computeIfAbsent(nums[i], n -> new ArrayList<>()).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> indices = values.get(target);
            return indices.get(random.nextInt(indices.size()));
        }
    }
}
