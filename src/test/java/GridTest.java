import org.junit.jupiter.api.Test;
import org.swiggy.Cell;
import org.swiggy.Grid;
import org.swiggy.exceptions.InvalidGridSizeException;
import org.swiggy.exceptions.InvalidSeedPercentageException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

    @Test
    public void testAllCellsDead_WhenUpdatingGrid_With1AliveCell() {
        Grid grid = new Grid(10, 10, 1);
        grid.updateGrid();
        assertTrue(grid.areAllCellsDead());
    }

    @Test
    public void testAllCellsNotDead_WhenUpdatingGrid_WithAllAliveCells() {
        Grid grid = new Grid(10, 10, 100);
        grid.updateGrid();
        assertFalse(grid.areAllCellsDead());
    }

    @Test
    public void testDisplayWhenAllCellsAlive() {
        Grid grid = new Grid(2, 2, 100);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        grid.display();

        String expectedOutput = "* * \n* * \n";
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    public void testDisplayWhenAllCellsDead() {
        Grid grid = new Grid(2, 2, 25);
        grid.updateGrid();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        grid.display();

        String expectedOutput = "- - \n- - \n";
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(originalOut);
    }
}
