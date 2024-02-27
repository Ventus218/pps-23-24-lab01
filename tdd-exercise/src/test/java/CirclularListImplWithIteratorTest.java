import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd2.*;

public class CirclularListImplWithIteratorTest {

    private CircularList circularList;

    @BeforeEach
    void resetTestClassFields() {
        circularList = new CircularListImpl();
    }

    @Test
    void sizeIsInitiallyZero() {
        assertEquals(0, circularList.size());
    }

    @Test
    void isEmptyIsCorrect() {
        assertEquals(circularList.size() == 0, circularList.isEmpty());
    }

    @Test
    void addSuccessfullyIncrementsListSize() {
        circularList.add(0);
        assertEquals(1, circularList.size());
    }

    @Test
    void forwardIteratorHasNextIsFalseWhenListIsEmpty() {
        assertFalse(circularList.forwardIterator().hasNext());
    }

    @Test
    void forwardIteratorCorrectlyIteratesToNextItemInList() {
        circularList.add(0);
        var forwardIterator = circularList.forwardIterator();
        assertAll(() -> assertTrue(forwardIterator.hasNext()), () -> assertEquals(0, forwardIterator.next()));
    }

    @Test
    void forwardIteratorCorrectlyCyclesTheList() {
        circularList.add(0);
        circularList.add(1);
        var forwardIterator = circularList.forwardIterator();
        forwardIterator.next();
        forwardIterator.next();
        assertEquals(0, forwardIterator.next());
    }

    @Test
    void backwardIteratorHasNextIsFalseWhenListIsEmpty() {
        assertFalse(circularList.backwardIterator().hasNext());
    }

    @Test
    void backwardIteratorCorrectlyIteratesToNextItemInList() {
        circularList.add(0);
        var backwardIterator = circularList.backwardIterator();
        assertAll(() -> assertTrue(backwardIterator.hasNext()), () -> assertEquals(0, backwardIterator.next()));
    }

    @Test
    void backwardIteratorCorrectlyCyclesTheList() {
        circularList.add(0);
        circularList.add(1);
        var backwardIterator = circularList.backwardIterator();
        backwardIterator.next();
        backwardIterator.next();
        assertEquals(1, backwardIterator.next());
    }

    @Test
    void forwardIteratorAndBackwardIteratorCorrectlyWorkTogether() {
        circularList.add(0);
        circularList.add(1);
        var forwardIterator = circularList.forwardIterator();
        var backwardIterator = circularList.backwardIterator();
        assertAll(() -> assertEquals(0, forwardIterator.next()), () -> assertEquals(0, backwardIterator.next()));
    }
}
