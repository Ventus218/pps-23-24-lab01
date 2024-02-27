package tdd2;

import java.util.Iterator;

public class CircularListImpl implements CircularList {

    private int size = 0;

    @Override
    public void add(int element) {
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'forwardIterator'");
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'backwardIterator'");
    }
}
