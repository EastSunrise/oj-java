package wsg.oj.java.leetcode.problems.p200;

import java.util.ArrayList;
import java.util.List;
import wsg.oj.java.leetcode.problems.p0.Solution79;

/**
 * 212. Word Search II (HARD)
 *
 * @author Kingen
 * @see Solution79
 * @see Solution980
 * @see <a href="https://leetcode-cn.com/problems/word-search-ii/">Word Search II</a>
 * @since 2021-07-27
 */
public class Solution212 extends Solution79 {

    /**
     * @complexity T=O(mnL), l=sum of the lengths of all words
     * @complexity S=O(L)
     * @see #BACKTRACKING
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                res.add(word);
            }
        }
        return res;
    }
}
