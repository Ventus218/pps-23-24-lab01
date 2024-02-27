package tdd3;

import java.util.Optional;
import java.util.function.Function;

public class CircularListImpl implements CircularList {

    private final tdd.CircularList circularList = new tdd.CircularListImpl();

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
        return circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return circularList.next();
    }

    @Override
    public Optional<Integer> previous() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'previous'");
    }

    @Override
    public void reset() {

    }

    @Override
    public Optional<Integer> filteredNext(Function<Integer, Boolean> a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filteredNext'");
    }

}
