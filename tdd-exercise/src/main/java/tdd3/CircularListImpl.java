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
        return circularList.previous();
    }

    @Override
    public void reset() {
        circularList.reset();
    }

    @Override
    public Optional<Integer> filteredNext(Function<Integer, Boolean> condition) {
        for (int i = 0; i < size(); i++) {
            var item = next().get();
            if (condition.apply(item)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

}
