import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
