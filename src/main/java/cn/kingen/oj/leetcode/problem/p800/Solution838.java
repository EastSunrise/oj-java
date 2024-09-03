package cn.kingen.oj.leetcode.problem.p800;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/push-dominoes/">838. Push Dominoes</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.TWO_POINTERS, Tag.STRING, Tag.DYNAMIC_PROGRAMMING},
        difficulty = Difficulty.MEDIUM
)
public class Solution838 {

    @Complexity(time = "O(n)", space = "O(1)")
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] chars = dominoes.toCharArray();
        int p = 0; // previous index of unbalanced dominoes
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'L') {
                if (p < i) {
                    if (chars[p] == 'R') { // R...L
                        for (int l = p + 1, r = i - 1; l < r; l++, r--) {
                            chars[l] = 'R';
                            chars[r] = 'L';
                        }
                    } else { // ...L or L...L
                        while (p < i) {
                            chars[p++] = 'L';
                        }
                    }
                }
                p = i + 1;
            } else if (chars[i] == 'R') {
                if (p < i) {
                    if (chars[p] == 'R') { // R...R
                        while (p < i) {
                            chars[p++] = 'R';
                        }
                    }
                    p = i;
                }
            }
        }
        if (p < n && chars[p] == 'R') { // end with R...
            while (p < n) {
                chars[p++] = 'R';
            }
        }
        return new String(chars);
    }
}