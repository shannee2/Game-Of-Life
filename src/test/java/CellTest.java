//package org.swiggy;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.swiggy.*;

public class CellTest {

    @Test
    public void testCellDefaultConstructor() {
        Cell cell = new Cell();
        assertFalse(cell.isAlive());
    }

    @Test
    public void testCellParameterizedConstructor() {
        Cell cell = new Cell(CellState.ALIVE);
        assertTrue(cell.isAlive());
    }

    @Test
    public void testGetNextState_Underpopulation_With0AliveNeighbour() {
        Cell cell = new Cell(CellState.ALIVE);
        List<Cell> neighbours = Arrays.asList(new Cell(CellState.DEAD), new Cell(CellState.DEAD), new Cell(CellState.DEAD));
        assertFalse(cell.getNextState(neighbours).isAlive());
    }

    @Test
    public void testGetNextState_Underpopulation_With1AliveNeighbour() {
        Cell cell = new Cell(CellState.ALIVE);
        List<Cell> neighbours = Arrays.asList(new Cell(CellState.ALIVE), new Cell(CellState.DEAD), new Cell(CellState.DEAD));
        assertFalse(cell.getNextState(neighbours).isAlive());
    }

    @Test
    public void testGetNextState_Underpopulation_When8Neighbours() {
        Cell cell = new Cell(CellState.ALIVE);
        List<Cell> neighbours = Arrays.asList(new Cell(CellState.DEAD), new Cell(CellState.ALIVE), new Cell(CellState.DEAD), new Cell(CellState.DEAD),new Cell(CellState.DEAD), new Cell(CellState.DEAD), new Cell(CellState.DEAD), new Cell(CellState.DEAD));
        assertFalse(cell.getNextState(neighbours).isAlive());
    }

    @Test
    public void testGetNextState_Overpopulation_With4AliveNeighbours() {
        Cell cell = new Cell(CellState.ALIVE);
        List<Cell> neighbours = Arrays.asList(new Cell(CellState.ALIVE), new Cell(CellState.ALIVE), new Cell(CellState.ALIVE), new Cell(CellState.ALIVE));
        assertFalse(cell.getNextState(neighbours).isAlive());
    }

    @Test
    public void testGetNextState_Overpopulation_With5AliveNeighbours() {
        Cell cell = new Cell(CellState.ALIVE);
        List<Cell> neighbours = Arrays.asList(new Cell(CellState.ALIVE), new Cell(CellState.ALIVE), new Cell(CellState.ALIVE), new Cell(CellState.ALIVE), new Cell(CellState.ALIVE));
        assertFalse(cell.getNextState(neighbours).isAlive());
    }
    @Test
    public void testGetNextState_Overpopulation_With8AliveNeighbours() {
        Cell cell = new Cell(CellState.ALIVE);
        List<Cell> neighbours = Arrays.asList(new Cell(CellState.ALIVE), new Cell(CellState.ALIVE), new Cell(CellState.ALIVE), new Cell(CellState.ALIVE), new Cell(CellState.ALIVE), new Cell(CellState.ALIVE), new Cell(CellState.ALIVE), new Cell(CellState.ALIVE));
        assertFalse(cell.getNextState(neighbours).isAlive());
    }

    @Test
    public void testGetNextState_Survival() {
        Cell cell = new Cell(CellState.ALIVE);
        List<Cell> neighbours = Arrays.asList(new Cell(CellState.ALIVE), new Cell(CellState.ALIVE));
        assertTrue(cell.getNextState(neighbours).isAlive());
    }

    @Test
    public void testGetNextState_Reproduction() {
        Cell cell = new Cell(CellState.DEAD);
        List<Cell> neighbours = Arrays.asList(new Cell(CellState.ALIVE), new Cell(CellState.ALIVE), new Cell(CellState.ALIVE));
        assertTrue(cell.getNextState(neighbours).isAlive());
    }

    @Test
    public void testEquals_SameState_WhenAlive() {
        assertEquals(new Cell(CellState.ALIVE), new Cell(CellState.ALIVE));
    }

    @Test
    public void testEquals_SameState_WhenDead() {
        assertEquals(new Cell(CellState.DEAD), new Cell(CellState.DEAD));
    }

    @Test
    public void testEquals_DifferentState() {
        assertNotEquals(new Cell(CellState.ALIVE), new Cell(CellState.DEAD));
    }


    @Test
    public void testToString() {
        assertEquals(ConsoleMessages.ALIVE.getRepresentation(), new Cell(CellState.ALIVE).toString());
        assertEquals(ConsoleMessages.DEAD.getRepresentation(), new Cell(CellState.DEAD).toString());
    }
}
