import org.junit.jupiter.api.Test;
import org.swiggy.Cell;
import org.swiggy.Characters;

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
        assertEquals(Characters.ALIVE.getRepresentation(), cell.toString());
    }

    @Test
    public void testCellToStringIfDead() {
        Cell cell = new Cell();
        assertEquals(Characters.DEAD.getRepresentation(), cell.toString());
    }
}
