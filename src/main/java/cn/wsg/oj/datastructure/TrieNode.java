package cn.wsg.oj.datastructure;

/**
 * Definition for a trie node.
 *
 * @author Kingen
 */
public class TrieNode {

    public final TrieNode[] next;
    public boolean end = false;

    public TrieNode(int size) {
        this.next = new TrieNode[size];
    }
}
