package wsg.oj.java.leetcode.problems.p600;

import java.util.List;
import wsg.oj.java.datastructure.TrieNode;
import wsg.oj.java.datastructure.TrieOpt;
import wsg.oj.java.leetcode.problems.base.Solution;
import wsg.oj.java.leetcode.problems.p200.Solution208;

/**
 * 648. Replace Words (MEDIUM)
 *
 * @author Kingen
 * @see Solution208
 * @see <a href="https://leetcode-cn.com/problems/replace-words/">Replace Words</a>
 * @since 2021-07-23
 */
public class Solution648 extends TrieOpt implements Solution {

    /**
     * @complexity T=O(M+N), M=the total size of the dictionary, N=the length of sentence
     * @complexity S=O(M)
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trie = create(dictionary, ch -> ch - 'a', 26);
        StringBuilder res = new StringBuilder();
        for (String word : sentence.split("\\s")) {
            TrieNode node = trie;
            int i = 0;
            while (i < word.length()) {
                int idx = word.charAt(i) - 'a';
                if (node.next[idx] == null || node.end) {
                    break;
                }
                node = node.next[idx];
                i++;
            }
            res.append(node.end ? word.substring(0, i) : word).append(' ');
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }
}
