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

    public Cell getNextState(List<Cell> cells){
        int aliveNeighbours = countAliveNeighbours(cells);

        if(aliveNeighbours < 2 || aliveNeighbours > 3){
            return new Cell(false);
        }

        return new Cell(true);
    }

    private int countAliveNeighbours(List<Cell> cells){
        int aliveNeighbours = 0;
        for(Cell cell: cells){
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
}
