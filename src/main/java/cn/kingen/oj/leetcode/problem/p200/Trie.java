package cn.kingen.oj.leetcode.problem.p200;

import cn.kingen.oj.leetcode.support.*;

import static cn.kingen.oj.leetcode.util.TrieUtils.insertWord;

/**
 * <a href="https://leetcode.cn/problems/implement-trie-prefix-tree/">208. Implement Trie (Prefix Tree)</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p200.WordDictionary
 * @see cn.kingen.oj.leetcode.problem.p600.Solution642
 * @see cn.kingen.oj.leetcode.problem.p600.Solution648
 * @see cn.kingen.oj.leetcode.problem.p600.MagicDictionary
 * @see cn.kingen.oj.leetcode.problem.p2200.Encrypter
 * @see cn.kingen.oj.leetcode.problem.p1800.Solution1804
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3045
 * @see cn.kingen.oj.leetcode.problem.p3000.Solution3042
 */
@Question(
        tags = {Tag.DESIGN, Tag.TRIE, Tag.HASH_TABLE, Tag.STRING},
        difficulty = Difficulty.MEDIUM
)
public class Trie {

    private final TrieNode root;

    @Complexity(time = "#", space = "O(T*C)", note = "T is sum of lengths of all words, C is 26")
    public Trie() {
        this.root = new TrieNode();
    }

    @Complexity(time = "O(n)", space = "O(n)")
    public void insert(String word) {
        insertWord(root, word);
    }

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean search(String word) {
        TrieNode t = find(word);
        return t != null && t.end;
    }

    private TrieNode find(String word) {
        TrieNode t = root;
        for (int i = 0, n = word.length(); i < n; i++) {
            int idx = word.charAt(i) - 'a';
            if (t.next[idx] == null) {
                return null;
            }
            t = t.next[idx];
        }
        return t;
    }

    @Complexity(time = "O(n)", space = "O(1)")
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }
}