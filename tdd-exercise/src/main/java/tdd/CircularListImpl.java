package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private int currentIndex;

    private List<Integer> list = new ArrayList<>();

    public CircularListImpl() {
        reset();
    }

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

        var result =  Optional.of(list.get(currentIndex));
        incrementCurrentIndex();
        return result;
    }

    @Override
    public Optional<Integer> previous() {
        if (size() == 0) {
            return Optional.empty();
        }
        decrementCurrentIndex();
        return Optional.of(list.get(currentIndex));
    }

    @Override
    public void reset() {
        currentIndex = 0;
    }

    /**
     * Increments the currentIndex field implementing circular logic based onto the
     * list.
     */
    private void incrementCurrentIndex() {
        currentIndex = (currentIndex + 1) % list.size();
    }

    /**
     * Decrements the currentIndex field implementing circular logic based onto the
     * list.
     */
    private void decrementCurrentIndex() {
        currentIndex = Math.abs((currentIndex - 1) % list.size());
    }
}
