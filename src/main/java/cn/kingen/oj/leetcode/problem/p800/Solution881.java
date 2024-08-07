package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/boats-to-save-people/">881. Boats to Save People</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.TWO_POINTERS, Tag.SORTING},
        difficulty = Difficulty.MEDIUM
)
public class Solution881 {

    @Complexity(time = "O(n*log{n})", space = "O(log n)")
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, ans = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            ans++;
        }
        return ans;
    }
}