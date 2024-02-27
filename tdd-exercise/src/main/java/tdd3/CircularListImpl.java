package tdd3;

import java.util.Optional;
import java.util.function.Function;

public class CircularListImpl implements CircularList {

    @Override
    public void add(int element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

    @Override
    public Optional<Integer> previous() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'previous'");
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

    @Override
    public Optional<Integer> filteredNext(Function<Integer, Boolean> a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filteredNext'");
    }

}
