package cn.kingen.oj.leetcode.problem.p3300;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/">3306. Count of Substrings Containing Every Vowel and K Consonants II</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1839
 * @see cn.kingen.oj.leetcode.problem.p2000.Solution2062

 */
@Question(
        tags = {Tag.HASH_TABLE, Tag.STRING, Tag.SLIDING_WINDOW},
        difficulty = Difficulty.MEDIUM,
        contest = 417
)
public class Solution3306 {

    @Complexity(time = "O(n)", space = "O(n+C)", note = "C is 26 here")
    public long countOfSubstrings(String word, int k) {
        int n = word.length(), mask = 0;
        for (char vowel : new char[]{'a', 'e', 'i', 'o', 'u'}) {
            mask |= 1 << (vowel - 'a');
        }

        int[] followedVowels = new int[n]; // f[i] is the number of consecutive vowels following word[i]
        for (int i = n - 1, cnt = 0; i >= 0; i--) {
            followedVowels[i] = cnt;
            if ((mask >>> (word.charAt(i) - 'a') & 1) == 1) {
                cnt++;
            } else {
                cnt = 0;
            }
        }

        int consonant = 0, vowel = 0;
        int[] cnt = new int[26];
        long ans = 0;
        for (int i = 0, j = 0; i < n; i++) {
            for (; j < n && (consonant < k || vowel < 5); j++) {
                int ch = word.charAt(j) - 'a';
                if ((mask >>> ch & 1) == 1) {
                    if (cnt[ch]++ == 0) {
                        vowel++;
                    }
                } else {
                    consonant++;
                }
            }

            if (consonant == k && vowel == 5) { // solutions starting from word[i]
                ans += followedVowels[j - 1] + 1;
            }

            int ch = word.charAt(i) - 'a';
            if ((mask >>> ch & 1) == 1) {
                if (--cnt[ch] == 0) {
                    vowel--;
                }
            } else {
                consonant--;
            }
        }
        return ans;
    }
}