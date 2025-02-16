package org.swiggy;

import java.util.List;

public class Cell {
    private final CellState state;

    public Cell(CellState state) {
        this.state = state;
    }

    public Cell() {
        this.state = CellState.DEAD;
    }

    public boolean isAlive() {
        return state == CellState.ALIVE;
    }

    public Cell getNextState(List<Cell> neighbourCells){
        int aliveNeighbours = countAliveNeighbours(neighbourCells);
        CellState beAlive = (aliveNeighbours == 2 || aliveNeighbours == 3) ? CellState.ALIVE : CellState.DEAD;
        if(beAlive == this.state) {
            return this;
        }
        return new Cell(beAlive);
    }

    private int countAliveNeighbours(List<Cell> neighbourCells){
        int aliveNeighbours = 0;
        for(Cell cell: neighbourCells){
            if(cell.isAlive()){
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }

    @Override
    public String toString() {
        return this.isAlive() ? ConsoleMessages.ALIVE.getRepresentation() : ConsoleMessages.DEAD.getRepresentation();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cell other = (Cell) obj;
        return this.state == other.state;
    }
}
