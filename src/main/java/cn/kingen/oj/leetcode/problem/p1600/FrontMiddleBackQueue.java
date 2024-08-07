package cn.kingen.oj.leetcode.problem.p1600;

import cn.kingen.oj.leetcode.support.Complexity;
import cn.kingen.oj.leetcode.support.Difficulty;
import cn.kingen.oj.leetcode.support.Question;
import cn.kingen.oj.leetcode.support.Tag;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/design-front-middle-back-queue/">1670. Design Front Middle Back Queue</a>
 *
 * @author Kingen
 * @see cn.kingen.oj.leetcode.problem.p600.MyCircularDeque
 * @see cn.kingen.oj.leetcode.problem.p600.MyCircularQueue
 */
@Question(
        tags = {Tag.DESIGN, Tag.QUEUE, Tag.ARRAY, Tag.LINKED_LIST, Tag.DATA_STREAM},
        difficulty = Difficulty.MEDIUM
)
public class FrontMiddleBackQueue {

    private final Deque<Integer> front;
    private final Deque<Integer> back;

    @Complexity(time = "O(1)", space = "O(n)")
    FrontMiddleBackQueue() {
        this.front = new LinkedList<>();
        this.back = new LinkedList<>();
    }

    @Complexity(time = "O(1)", space = "O(1)")
    void pushFront(int val) {
        if (isBalance()) {
            front.addFirst(val);
            back.addFirst(front.removeLast());
        } else {
            front.addFirst(val);
        }
    }

    /**
     * Either {@code front.size()==back.size()} or {@code front.size()+1=back.size()}
     */
    boolean isBalance() {
        return this.front.size() == this.back.size();
    }

    @Complexity(time = "O(1)", space = "O(1)")
    void pushMiddle(int val) {
        if (isBalance()) {
            back.addFirst(val);
        } else {
            front.addLast(val);
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    void pushBack(int val) {
        if (isBalance()) {
            back.addLast(val);
        } else {
            back.addLast(val);
            front.addLast(back.removeFirst());
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    int popFront() {
        if (isBalance()) {
            if (front.isEmpty()) {
                return -1;
            }
        } else {
            front.addLast(back.removeFirst());
        }
        return front.removeFirst();
    }

    @Complexity(time = "O(1)", space = "O(1)")
    int popMiddle() {
        if (isBalance()) {
            if (front.isEmpty()) {
                return -1;
            }
            return front.removeLast();
        } else {
            return back.removeFirst();
        }
    }

    @Complexity(time = "O(1)", space = "O(1)")
    int popBack() {
        if (isBalance()) {
            if (front.isEmpty()) {
                return -1;
            }
            back.addFirst(front.removeLast());
        }
        return back.removeLast();
    }
}