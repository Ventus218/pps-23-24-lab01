import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.*;

import tdd3.*;

public class CircularListImplWithFilteredNext {
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
    void isEmptyWorksCorrectly() {
        assertEquals(circularList.size() == 0, circularList.isEmpty());
    }

    @Test
    void addIncrementsListSize() {
        circularList.add(0);
        assertEquals(1, circularList.size());
    }

    @Test
    void nextReturnsEmptyWhenListIsEmpty() {
        assertTrue(circularList.next().isEmpty());
    }

    @Test
    void nextReturnsCorrectItem() {
        circularList.add(0);
        var next = circularList.next();
        assertAll(
                () -> assertTrue(next.isPresent()),
                () -> assertEquals(0, next.get()));
    }

    @Test
    void nextCorrectlyCyclesTheList() {
        circularList.add(0);
        circularList.add(1);

        circularList.next();
        circularList.next();
        assertEquals(Optional.of(0), circularList.next());
    }
}
