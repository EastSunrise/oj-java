package wsg.oj.java.leetcode.problems.p300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 380. Insert Delete GetRandom O(1) (Medium)
 *
 * @author Kingen
 * @see Solution381
 * @see <a href="https://leetcode-cn.com/problems/insert-delete-getrandom-o1/">Insert Delete
 * GetRandom O(1)</a>
 * @since 2021-07-06
 */
public class Solution380 implements Solution {

    static class RandomizedSet {

        private final Map<Integer, Integer> indices;
        private final List<Integer> values;
        private final Random random = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            indices = new HashMap<>(16);
            values = new ArrayList<>(16);
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified
         * element.
         */
        public boolean insert(int val) {
            if (indices.containsKey(val)) {
                return false;
            }
            indices.put(val, values.size());
            values.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            Integer index = indices.remove(val);
            if (index == null) {
                return false;
            }
            if (index < values.size() - 1) {
                // swap with the tail element and delete
                int last = values.get(values.size() - 1);
                values.set(index, last);
                indices.put(last, index);
            }
            values.remove(values.size() - 1);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return values.get(random.nextInt(values.size()));
        }
    }
}
