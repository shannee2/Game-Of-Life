import org.junit.jupiter.api.Test;
import org.swiggy.Cell;
import org.swiggy.Grid;
import org.swiggy.exceptions.InvalidGridSizeException;
import org.swiggy.exceptions.InvalidSeedPercentageException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

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
        grid.update();
        assertTrue(grid.areAllCellsDead());
    }

    @Test
    public void testAllCellsNotDead_WhenUpdatingGrid_WithAllAliveCells() {
        Grid grid = new Grid(10, 10, 100);
        grid.update();
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
        grid.update();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        grid.display();

        String expectedOutput = "- - \n- - \n";
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(originalOut);
    }

    // More

    @Test
    public void test3X3Grid() {
        List<List<Cell>> initialCells = Arrays.asList(
                Arrays.asList(new Cell(false), new Cell(true), new Cell(false)),
                Arrays.asList(new Cell(true), new Cell(true), new Cell(false)),
                Arrays.asList(new Cell(false), new Cell(false), new Cell(false))
        );

        Grid grid = new Grid(initialCells);
        grid.update();

        List<List<Cell>> firstUpdateCells = Arrays.asList(
                Arrays.asList(new Cell(true), new Cell(true), new Cell(true)),
                Arrays.asList(new Cell(true), new Cell(true), new Cell(true)),
                Arrays.asList(new Cell(true), new Cell(true), new Cell(false))
        );
        Grid expectedGrid = new Grid(firstUpdateCells);

        assertEquals(expectedGrid, grid);
    }

    @Test
    public void test5X5Grid_WithMultipleUpdates() {
        List<List<Cell>> initialCells = Arrays.asList(
                Arrays.asList(new Cell(false), new Cell(true), new Cell(true), new Cell(false), new Cell(true)),
                Arrays.asList(new Cell(true), new Cell(true), new Cell(false), new Cell(false), new Cell(false)),
                Arrays.asList(new Cell(false), new Cell(true), new Cell(false), new Cell(false), new Cell(true)),
                Arrays.asList(new Cell(false), new Cell(false), new Cell(true), new Cell(true), new Cell(false)),
                Arrays.asList(new Cell(true), new Cell(true), new Cell(false), new Cell(true), new Cell(true))
        );

        Grid grid = new Grid(initialCells);

        // Update 1

        grid.update();

        List<List<Cell>> firstUpdateCells = Arrays.asList(
                Arrays.asList(new Cell(true), new Cell(true), new Cell(true), new Cell(true), new Cell(false)),
                Arrays.asList(new Cell(true), new Cell(false), new Cell(false), new Cell(true), new Cell(true)),
                Arrays.asList(new Cell(true), new Cell(true), new Cell(false), new Cell(true), new Cell(false)),
                Arrays.asList(new Cell(true), new Cell(false), new Cell(false), new Cell(false), new Cell(false)),
                Arrays.asList(new Cell(false), new Cell(true), new Cell(false), new Cell(true), new Cell(true))
        );

        Grid expectedGrid = new Grid(firstUpdateCells);
        assertEquals(expectedGrid, grid);

        // Update 2

        grid.update();

        List<List<Cell>> secondUpdateCells = Arrays.asList(
                Arrays.asList(new Cell(true), new Cell(true), new Cell(true), new Cell(true), new Cell(true)),
                Arrays.asList(new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(true)),
                Arrays.asList(new Cell(true), new Cell(true), new Cell(true), new Cell(true), new Cell(true)),
                Arrays.asList(new Cell(true), new Cell(false), new Cell(false), new Cell(true), new Cell(true)),
                Arrays.asList(new Cell(true), new Cell(false), new Cell(true), new Cell(false), new Cell(false))
        );

        expectedGrid = new Grid(secondUpdateCells);
        assertEquals(expectedGrid, grid);
    }

    @Test
    public void testGridWithNoAliveCellsRemainsDead() {
        List<List<Cell>> deadCells = Arrays.asList(
                Arrays.asList(new Cell(false), new Cell(false)),
                Arrays.asList(new Cell(false), new Cell(false))
        );

        Grid grid = new Grid(deadCells);
        grid.update();
        assertTrue(grid.areAllCellsDead());
    }

    @Test
    public void testGridWithAllAliveCellsEvolves() {
        List<List<Cell>> aliveCells = Arrays.asList(
                Arrays.asList(new Cell(true), new Cell(true)),
                Arrays.asList(new Cell(true), new Cell(true))
        );

        Grid grid = new Grid(aliveCells);
        grid.update();
        grid.update();
        grid.update();
        grid.update();
        grid.update();
        grid.update();

        List<List<Cell>> expectedCells = Arrays.asList(
                Arrays.asList(new Cell(true), new Cell(true)),
                Arrays.asList(new Cell(true), new Cell(true))
        );
        Grid expectedGrid = new Grid(expectedCells);


        assertEquals(expectedGrid, grid);
    }
}
