package cn.kingen.oj.leetcode.problem.p600;

import cn.kingen.oj.leetcode.support.*;

import java.util.List;

import static cn.kingen.oj.leetcode.util.TrieUtils.insertWord;

/**
 * <a href="https://leetcode.cn/problems/replace-words/">648. Replace Words</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.Trie
 */
@Question(
        tags = {Tag.TRIE, Tag.ARRAY, Tag.HASH_TABLE, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Solution648 {

    @Complexity(time = "O(M+N)", space = "O(M)", note = "M is the total size of the dictionary, N is the length of sentence")
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        dictionary.forEach(word -> insertWord(root, word));
        StringBuilder ans = new StringBuilder();
        for (String word : sentence.split("\\s")) {
            TrieNode t = root;
            int i = 0;
            for (int n = word.length(); i < n; i++) {
                int idx = word.charAt(i) - 'a';
                if (t.next[idx] == null || t.end) {
                    break;
                }
                t = t.next[idx];
            }
            ans.append(t.end ? word.substring(0, i) : word).append(' ');
        }
        return ans.deleteCharAt(ans.length() - 1).toString();
    }
}