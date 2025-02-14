package org.swiggy;

import java.util.List;

public class Cell {
    private final boolean isAlive;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Cell() {
        this.isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Cell getNextState(List<Cell> neighbourCells){
        int aliveNeighbours = countAliveNeighbours(neighbourCells);

        if(aliveNeighbours < 2 || aliveNeighbours > 3){
            return new Cell(false);
        }

        return new Cell(true);
    }

    private int countAliveNeighbours(List<Cell> neighbourCells){
        int aliveNeighbours = 0;
        for(Cell cell: neighbourCells){
            if(cell.isAlive){
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }

    @Override
    public String toString() {
        return isAlive ? ConsoleMessages.ALIVE.getRepresentation() : ConsoleMessages.DEAD.getRepresentation();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cell other = (Cell) obj;
        return this.isAlive == other.isAlive;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(isAlive);
    }
}
