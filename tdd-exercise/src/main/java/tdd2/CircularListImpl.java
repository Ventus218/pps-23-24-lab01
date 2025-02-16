package tdd2;

import java.util.Iterator;

public class CircularListImpl implements CircularList {

    private final tdd.CircularListImpl circularList = new tdd.CircularListImpl();

    @Override
    public void add(int element) {
        circularList.add(element);
    }

    @Override
    public int size() {
        return circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    return circularList.next().get();
                } else {
                    throw new IllegalStateException(
                            "Iterator has no more next items. If hasNext method returns false then the next method should not be called.");
                }
            }
        };
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    return circularList.previous().get();
                } else {
                    throw new IllegalStateException(
                            "Iterator has no more next items. If hasNext method returns false then the next method should not be called.");
                }
            }
        };
    }
}
