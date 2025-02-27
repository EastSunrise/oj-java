package cn.kingen.oj.leetcode.problem.p2200;

import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

/**
 * <a href="https://leetcode.cn/problems/design-a-text-editor/">2296. Design a Text Editor</a>
 *
 * @author Kingen
 */
@Question(
        tags = {Tag.STACK, Tag.DESIGN, Tag.LINKED_LIST, Tag.STRING, Tag.DOUBLY_LINKED_LIST, Tag.SIMULATION},
        difficulty = Difficulty.HARD,
        date = "2025-02-27"
)
public class TextEditor {

    private Node prev = null, next = null;

    public TextEditor() {
    }

    public void addText(String text) {
        int n = text.length();
        Node first = new Node(text.charAt(0), prev, null);
        if (prev != null) {
            prev.next = first;
        }
        prev = first;

        for (int i = 1; i < n; i++) {
            Node node = new Node(text.charAt(i), prev, null);
            prev.next = node;
            prev = node;
        }
        prev.next = next;
        if (next != null) {
            next.prev = prev;
        }
    }

    public int deleteText(int k) {
        int cnt = 0;
        while (cnt++ < k && prev != null) {
            prev = prev.prev;
        }
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        return cnt - 1;
    }

    public String cursorLeft(int k) {
        while (k-- > 0 && prev != null) {
            next = prev;
            prev = prev.prev;
        }
        return getLeft10();
    }

    public String cursorRight(int k) {
        while (k-- > 0 && next != null) {
            prev = next;
            next = next.next;
        }
        return getLeft10();
    }

    private String getLeft10() {
        char[] chars = new char[10];
        Node t = prev;
        int i = 9;
        while (i >= 0 && t != null) {
            chars[i--] = t.ch;
            t = t.prev;
        }
        return new String(chars, i + 1, 9 - i);
    }

    private static class Node {
        char ch;
        Node prev, next;

        Node(char ch, Node prev, Node next) {
            this.ch = ch;
            this.prev = prev;
            this.next = next;
        }
    }
}