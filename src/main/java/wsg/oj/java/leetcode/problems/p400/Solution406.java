package wsg.oj.java.leetcode.problems.p400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import wsg.oj.java.leetcode.problems.base.Solution;

/**
 * 406. Queue Reconstruction by Height (Medium)
 *
 * @author Kingen
 * @see Solution315
 * @see <a href="https://leetcode-cn.com/problems/queue-reconstruction-by-height/">Queue
 * Reconstruction by Height</a>
 * @since 2021-07-07
 */
class Solution406 extends Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            int h = o1[0] - o2[0];
            if (h != 0) {
                return h;
            }
            return o2[1] - o1[1];
        });
        List<Integer> indices = new ArrayList<>(people.length);
        for (int i = 0; i < people.length; i++) {
            indices.add(i);
        }
        int[][] res = new int[people.length][];
        for (int[] person : people) {
            int index = indices.remove(person[1]);
            res[index] = person;
        }
        return res;
    }
}
