package wsg.oj.java.leetcode.problems.old;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kingen
 */
public class NestedIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new LinkedList<>();
        for (NestedInteger nestedInteger : nestedList) {
            list.addAll(getList(nestedInteger));
        }
        iterator = list.iterator();
    }

    private List<Integer> getList(NestedInteger nestedInteger) {
        List<Integer> list = new LinkedList<>();
        if (nestedInteger.isInteger()) {
            list.add(nestedInteger.getInteger());
        } else {
            for (NestedInteger integer : nestedInteger.getList()) {
                list.addAll(getList(integer));
            }
        }
        return list;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public void remove() {

    }
}
