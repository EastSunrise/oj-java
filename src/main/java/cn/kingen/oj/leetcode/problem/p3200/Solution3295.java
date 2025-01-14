package cn.kingen.oj.leetcode.problem.p3200;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/report-spam-message/">3295. Report Spam Message</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING},
        difficulty = Difficulty.MEDIUM,
        contest = 416
)
public class Solution3295 {

    @Complexity(time = "O(m+n)", space = "O(n)")
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(bannedWords));
        int count = 0;
        for (String word : message) {
            if (bannedSet.contains(word) && ++count >= 2) {
                return true;
            }
        }
        return false;
    }
}