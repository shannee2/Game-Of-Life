import org.junit.jupiter.api.Test;
import org.swiggy.Cell;
import org.swiggy.Grid;
import org.swiggy.exceptions.InvalidGridSizeException;
import org.swiggy.exceptions.InvalidSeedPercentageException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {
    @Test
    public void testThrowException_WhenGridInitializedWithNegativeRows() {
        assertThrows(InvalidGridSizeException.class, () -> new Grid(-1, 1,10));
    }

    @Test
    public void testThrowException_WhenGridInitializedWithNegativeCols() {
        assertThrows(InvalidGridSizeException.class, () -> new Grid(1, -1,10));
    }

    @Test
    public void testGridCreation() {
        assertDoesNotThrow(()->new Grid(1,1,10));
    }

    @Test
    public void testThrowException_WhenSeedPercentageIsNegative() {
        assertThrows(InvalidSeedPercentageException.class, () -> new Grid(1, 1, -1));
    }

    @Test
    public void testThrowException_WhenSeedPercentageIsZero() {
        assertThrows(InvalidSeedPercentageException.class, () -> new Grid(1, 1, 0));
    }
}
