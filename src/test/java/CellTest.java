import org.junit.jupiter.api.Test;
import org.swiggy.Cell;
import org.swiggy.ConsoleMessages;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void testCellCreation() {
        Cell cell = new Cell();
        assertFalse(cell.isAlive());
    }

    @Test
    public void testAliveCell() {
        Cell cell = new Cell();
        cell.makeAlive();
        assertTrue(cell.isAlive());
    }

    @Test
    public void testCellToStringIfAlive() {
        Cell cell = new Cell();
        cell.makeAlive();
        assertEquals(ConsoleMessages.ALIVE.getRepresentation(), cell.toString());
    }

    @Test
    public void testCellToStringIfDead() {
        Cell cell = new Cell();
        assertEquals(ConsoleMessages.DEAD.getRepresentation(), cell.toString());
    }
}
