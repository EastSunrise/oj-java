package cn.kingen.oj.leetcode.problem.p2700;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/split-strings-by-separator/">2788. Split Strings by Separator</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1200.Solution1221
 */
@Question(
        tags = {Tag.ARRAY, Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Solution2788 {

    @Complexity(time = "O(n*l)", space = "O(1)")
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            int offset = 0, next;
            while ((next = word.indexOf(separator, offset)) != -1) {
                if (offset != next) {
                    ans.add(word.substring(offset, next));
                }
                offset = next + 1;
            }
            if (offset != word.length()) {
                ans.add(word.substring(offset));
            }
        }
        return ans;
    }
}