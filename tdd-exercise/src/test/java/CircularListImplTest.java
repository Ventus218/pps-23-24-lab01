import org.junit.jupiter.api.BeforeEach;

import tdd.CircularList;
import tdd.CircularListImpl;

public class CircularListImplTest {
    private CircularList circularList;

    @BeforeEach
    void resetTestClassFields() {
        circularList = new CircularListImpl();
    }
}
