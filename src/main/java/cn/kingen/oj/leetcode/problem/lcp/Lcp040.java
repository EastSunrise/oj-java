package cn.kingen.oj.leetcode.problem.lcp;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/uOAnQW/">LCP 40. 心算挑战</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.GREEDY, Tag.ARRAY, Tag.SORTING},
        difficulty = Difficulty.EASY
)
public class Lcp040 {

    @Complexity(time = "O(nlogn)", space = "O(1)")
    public int maxmiumScore(int[] cards, int cnt) {
        int n = cards.length;
        Arrays.sort(cards);
        int sum = 0, i = n - 1;
        while (cnt-- > 0) {
            sum += cards[i--];
        }
        if (sum % 2 == 0) { // the first cnt cards
            return sum;
        }

        int ans = 0;
        int minOdd = Integer.MAX_VALUE, minEven = Integer.MAX_VALUE;
        for (int j = i + 1; j < n; j++) {
            if (cards[j] % 2 == 1) {
                minOdd = cards[j];
                break;
            }
        }
        if (minOdd != Integer.MAX_VALUE) { // replace the min used odd card with the max unused even card
            for (int j = i; j >= 0; j--) {
                if (cards[j] % 2 == 0) {
                    ans = Math.max(ans, sum - minOdd + cards[j]);
                    break;
                }
            }
        }

        for (int j = i + 1; j < n; j++) {
            if (cards[j] % 2 == 0) {
                minEven = cards[j];
                break;
            }
        }
        if (minEven != Integer.MAX_VALUE) { // replace the min used even card with the max unused odd card
            for (int j = i; j >= 0; j--) {
                if (cards[j] % 2 == 1) {
                    ans = Math.max(ans, sum - minEven + cards[j]);
                    break;
                }
            }
        }
        return ans;
    }
}