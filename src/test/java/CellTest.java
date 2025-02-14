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
        Cell cell = new Cell(true);
        assertTrue(cell.isAlive());
    }

    @Test
    public void testGetNextState_Underpopulation_With0AliveNeighbour() {
        Cell cell = new Cell(true);
        List<Cell> neighbours = Arrays.asList(new Cell(false), new Cell(false), new Cell(false));
        assertFalse(cell.getNextState(neighbours).isAlive());
    }

    @Test
    public void testGetNextState_Underpopulation_With1AliveNeighbour() {
        Cell cell = new Cell(true);
        List<Cell> neighbours = Arrays.asList(new Cell(true), new Cell(false), new Cell(false));
        assertFalse(cell.getNextState(neighbours).isAlive());
    }

    @Test
    public void testGetNextState_Underpopulation_When8Neighbours() {
        Cell cell = new Cell(true);
        List<Cell> neighbours = Arrays.asList(new Cell(false), new Cell(true), new Cell(false), new Cell(false),new Cell(false), new Cell(false), new Cell(false), new Cell(false));
        assertFalse(cell.getNextState(neighbours).isAlive());
    }

    @Test
    public void testGetNextState_Overpopulation_With4AliveNeighbours() {
        Cell cell = new Cell(true);
        List<Cell> neighbours = Arrays.asList(new Cell(true), new Cell(true), new Cell(true), new Cell(true));
        assertFalse(cell.getNextState(neighbours).isAlive());
    }

    @Test
    public void testGetNextState_Overpopulation_With5AliveNeighbours() {
        Cell cell = new Cell(true);
        List<Cell> neighbours = Arrays.asList(new Cell(true), new Cell(true), new Cell(true), new Cell(true), new Cell(true));
        assertFalse(cell.getNextState(neighbours).isAlive());
    }
    @Test
    public void testGetNextState_Overpopulation_With8AliveNeighbours() {
        Cell cell = new Cell(true);
        List<Cell> neighbours = Arrays.asList(new Cell(true), new Cell(true), new Cell(true), new Cell(true), new Cell(true), new Cell(true), new Cell(true), new Cell(true));
        assertFalse(cell.getNextState(neighbours).isAlive());
    }

    @Test
    public void testGetNextState_Survival() {
        Cell cell = new Cell(true);
        List<Cell> neighbours = Arrays.asList(new Cell(true), new Cell(true));
        assertTrue(cell.getNextState(neighbours).isAlive());
    }

    @Test
    public void testGetNextState_Reproduction() {
        Cell cell = new Cell(false);
        List<Cell> neighbours = Arrays.asList(new Cell(true), new Cell(true), new Cell(true));
        assertTrue(cell.getNextState(neighbours).isAlive());
    }

    @Test
    public void testEquals_SameState_WhenAlive() {
        assertEquals(new Cell(true), new Cell(true));
    }

    @Test
    public void testEquals_SameState_WhenDead() {
        assertEquals(new Cell(false), new Cell(false));
    }

    @Test
    public void testEquals_DifferentState() {
        assertNotEquals(new Cell(true), new Cell(false));
    }


    @Test
    public void testToString() {
        assertEquals(ConsoleMessages.ALIVE.getRepresentation(), new Cell(true).toString());
        assertEquals(ConsoleMessages.DEAD.getRepresentation(), new Cell(false).toString());
    }
}
