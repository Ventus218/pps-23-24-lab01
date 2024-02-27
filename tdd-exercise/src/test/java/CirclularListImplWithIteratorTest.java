import org.junit.jupiter.api.BeforeEach;

import tdd2.*;

public class CirclularListImplWithIteratorTest {

    private CircularList circularList;

    @BeforeEach
    void resetTestClassFields() {
        circularList = new CircularListImpl();
    }

}
