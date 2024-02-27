import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
