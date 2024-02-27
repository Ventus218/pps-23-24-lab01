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
}
