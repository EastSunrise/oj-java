package cn.kingen.oj.leetcode.problem.p3400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/assign-elements-to-groups-with-constraints/">3447. Assign Elements to Groups with Constraints</a>
 *
 * @author Kingen

 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE},
        difficulty = Difficulty.MEDIUM,
        contest = 436
)
public class Solution3447 {

    @Complexity(time = "O(n+U*log(m))", space = "O(U)", note = "U is the maximum of groups")
    public int[] assignElements(int[] groups, int[] elements) {
        int n = groups.length, m = elements.length;
        int max = 0;
        for (int num : groups) {
            max = Math.max(max, num);
        }

        int[] targets = new int[max + 1];
        Arrays.fill(targets, -1);
        for (int i = 0; i < m; i++) {
            int p = elements[i];
            if (p > max || targets[p] != -1) {
                continue;
            }

            for (int y = p; y <= max; y += p) {
                if (targets[y] == -1) {
                    targets[y] = i;
                }
            }
        }

        int[] assigned = new int[n];
        for (int i = 0; i < n; i++) {
            assigned[i] = targets[groups[i]];
        }
        return assigned;
    }
}