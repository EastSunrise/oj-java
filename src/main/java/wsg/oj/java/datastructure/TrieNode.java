package wsg.oj.java.datastructure;

/**
 * Definition for a trie node.
 *
 * @author Kingen
 * @since 2021/7/24
 */
public class TrieNode {

    public final TrieNode[] next;
    public boolean end = false;

    public TrieNode(int size) {
        this.next = new TrieNode[size];
    }
}
