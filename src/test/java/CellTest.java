import org.junit.jupiter.api.Test;
import org.swiggy.Cell;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void testCellCreation() {
        Cell cell = new Cell();
        assertFalse(cell.isAlive());
    }
}
