import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

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

    @Test
    void addAddsAnItem() {
        circularList.add(0);
        assertEquals(1, circularList.size());
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
        assertEquals(Optional.of(0), circularList.previous());
    }
}
