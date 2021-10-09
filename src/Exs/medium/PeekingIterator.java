package Exs.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wy
 * @date 2021/10/4 21:27
 */
public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer cache;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.cache = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer last = cache;
        cache = iterator.hasNext() ? iterator.next() : null;
        return last;
    }

    @Override
    public boolean hasNext() {
        return cache != null;
    }
}
