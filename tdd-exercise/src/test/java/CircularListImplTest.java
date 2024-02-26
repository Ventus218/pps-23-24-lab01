import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

public class CircularListImplTest {
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
        assertEquals(true, circularList.isEmpty());
    }
}
