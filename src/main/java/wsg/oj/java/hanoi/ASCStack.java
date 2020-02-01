package wsg.oj.java.hanoi;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author Kingen
 */
public class ASCStack<T extends Comparable<T>> {
    private Stack<T> stack;

    public ASCStack() {
        this.stack = new Stack<>();
    }

    public void push(T t) throws Exception {
        if (stack.empty() || stack.peek().compareTo(t) <= 0) {
            stack.push(t);
            return;
        }
        throw new Exception("Not asc.");
    }

    public T pop() {
        return stack.pop();
    }

    public int size() {
        return stack.size();
    }

    public void print() {
        Iterator<T> iterator = stack.iterator();
        if (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        while (iterator.hasNext()) {
            System.out.print("," + iterator.next());
        }
        System.out.println();
    }
}
