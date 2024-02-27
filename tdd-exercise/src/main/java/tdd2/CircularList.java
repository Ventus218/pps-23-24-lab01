package tdd2;

import java.util.Iterator;

/**
 * Represents a list of integers, which can be traversed bidirectionally and
 * circularly by using the provided iterators.
 */
public interface CircularList {

    /**
     * Adds an element to the list, namely, after the last inserted one.
     * 
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * Provides the current size of the list
     * 
     * @return the size of the list
     */
    int size();

    /**
     * Checks if the list is empty
     * 
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    Iterator<Integer> forwardIterator();

    Iterator<Integer> backwardIterator();
}
