import org.junit.jupiter.api.Test;
import org.swiggy.Cell;
import org.swiggy.Grid;
import org.swiggy.exceptions.InvalidGridSizeException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {
    @Test
    public void testThrowException_WhenGridInitializedWithNegativeRows() {
        assertThrows(InvalidGridSizeException.class, () -> new Grid(-1, 1));
    }

    @Test
    public void testThrowException_WhenGridInitializedWithNegativeCols() {
        assertThrows(InvalidGridSizeException.class, () -> new Grid(1, -1));
    }

    @Test
    public void testGridCreation() {
        assertDoesNotThrow(()->new Grid(1,1));
    }
}
