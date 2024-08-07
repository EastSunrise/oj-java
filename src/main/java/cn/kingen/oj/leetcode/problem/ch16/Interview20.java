package cn.kingen.oj.leetcode.problem.ch16;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/t9-lcci/">面试题 16.20. T9 LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Interview20 {

    static char[] letter2digit = new char[]{
            '2', '2', '2', // abc
            '3', '3', '3', // def
            '4', '4', '4', // ghi
            '5', '5', '5', // jkl
            '6', '6', '6', // mno
            '7', '7', '7', '7', // pqrs
            '8', '8', '8', // tuv
            '9', '9', '9', '9', // wxyz
    };

    @Complexity(time = "O(mn)", space = "O(n)", note = "m is the number of words")
    public List<String> getValidT9Words(String num, String[] words) {
        int n = num.length();
        char[] nums = num.toCharArray();
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            int i = 0;
            for (; i < n; i++) {
                if (letter2digit[word.charAt(i) - 'a'] != nums[i]) {
                    break;
                }
            }
            if (i == n) {
                ans.add(word);
            }
        }
        return ans;
    }
}