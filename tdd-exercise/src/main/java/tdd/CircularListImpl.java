package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private int currentIndex = -1;

    private List<Integer> list = new ArrayList<>();

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (size() == 0) {
            return Optional.empty();
        }

        incrementCurrentIndex();
        return Optional.of(list.get(currentIndex));
    }

    @Override
    public Optional<Integer> previous() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'previous'");
    }

    @Override
    public void reset() {
        list.clear();
    }

    /**
     * Increments the currentIndex field implementing circular logic based onto the
     * list.
     */
    private void incrementCurrentIndex() {
        currentIndex = (currentIndex + 1) % list.size();
    }
}
