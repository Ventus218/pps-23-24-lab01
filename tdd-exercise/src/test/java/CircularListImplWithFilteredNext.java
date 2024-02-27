import org.junit.jupiter.api.*;

import tdd3.*;

public class CircularListImplWithFilteredNext {
    private CircularList circularList;

    @BeforeEach
    void resetTestClassFields() {
        circularList = new CircularListImpl();
    }
}
