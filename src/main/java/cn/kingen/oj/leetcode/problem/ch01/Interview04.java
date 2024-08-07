package cn.kingen.oj.leetcode.problem.ch01;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Map;

import static cn.kingen.oj.leetcode.util.StringUtils.statFrequency;

/**
 * <a href="https://leetcode.cn/problems/palindrome-permutation-lcci/">面试题 01.04. Palindrome Permutation LCCI</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.BIT_MANIPULATION, Tag.HASH_TABLE, Tag.STRING},
        difficulty = Difficulty.EASY
)
public class Interview04 {

    @Complexity(time = "O(n+C)", space = "O(C)", note = "C is the number of distinct characters")
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> count = statFrequency(s);
        int odd = 0;
        for (int c : count.values()) {
            if (c % 2 == 1) {
                odd++;
            }
        }
        return odd <= 1;
    }
}