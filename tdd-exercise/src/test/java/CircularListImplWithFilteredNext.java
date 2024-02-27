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

    @Test
    void previousReturnsEmptyWhenListIsEmpty() {
        assertTrue(circularList.previous().isEmpty());
    }

    @Test
    void previousReturnsCorrectItem() {
        circularList.add(0);
        var previous = circularList.previous();
        assertAll(
                () -> assertTrue(previous.isPresent()),
                () -> assertEquals(0, previous.get()));
    }

    @Test
    void previousCorrectlyCyclesTheList() {
        circularList.add(0);
        circularList.add(1);

        circularList.previous();
        circularList.previous();
        assertEquals(Optional.of(1), circularList.previous());
    }

    @Test
    void resetWorks() {
        circularList.add(0);
        circularList.add(1);
        circularList.next();
        circularList.reset();
        assertEquals(0, circularList.next().get());
    }

    @Test
    void filteredNextReturnsEmptyWhenListIsEmpty() {
        assertTrue(circularList.filteredNext((element) -> true).isEmpty());
    }

    @Test
    void filteredNextReturnsEmptyWhenNoItemSatisfiesCondition() {
        circularList.add(0);
        circularList.add(1);
        circularList.add(6);
        assertTrue(circularList.filteredNext((element) -> element == 5).isEmpty());
    }

    @Test
    void filteredNextReturnsItemWhichSatisfiesCondition() {
        circularList.add(0);
        circularList.add(1);
        circularList.add(2);
        assertEquals(1, circularList.filteredNext((element) -> element == 1).get());
    }

    @Test
    void filteredNextReturnsFirstItemWhichSatisfiesCondition() {
        circularList.add(0);
        circularList.add(1);
        circularList.add(1);
        circularList.filteredNext((element) -> element == 1);
        assertEquals(1, circularList.next().get());
    }

    @Test
    void filteredNextCanCycleTheList() {
        circularList.add(0);
        circularList.add(1);
        circularList.next();
        assertEquals(0, circularList.filteredNext((element) -> element == 0).get());
    }
}
