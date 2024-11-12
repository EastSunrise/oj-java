package cn.kingen.oj.leetcode.problem.p1400;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/destination-city/">1436. Destination City</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution1436 {

    @Complexity(time = "O(n)", space = "O(n)")
    public String destCity(List<List<String>> paths) {
        Set<String> froms = new HashSet<>(paths.size());
        for (List<String> path : paths) {
            froms.add(path.getFirst());
        }
        for (List<String> path : paths) {
            if (!froms.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return null;
    }
}