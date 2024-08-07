package cn.kingen.oj.leetcode.support;

/**
 * Definition for a trie node.
 *
 * @author Kingen
 */
public class TrieNode {

    public static final int DEFAULT_SIZE = 26;

    public final TrieNode[] next;
    public boolean end = false;

    public TrieNode() {
        this(DEFAULT_SIZE);
    }

    public TrieNode(int size) {
        this.next = new TrieNode[size];
    }
}
