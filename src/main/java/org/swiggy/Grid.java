package org.swiggy;

import org.swiggy.exceptions.InvalidSeedPercentageException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grid {
    List<List<Cell>> cells;

    public Grid(int rows, int cols, int seedPercentage) {
        if(seedPercentage <= 0 || seedPercentage > 100){
            throw new InvalidSeedPercentageException();
        }
        if (rows <= 0 || cols <= 0) {
            throw new org.swiggy.exceptions.InvalidGridSizeException();
        }
        initializeGrid(rows, cols, seedPercentage);
    }

    private void initializeGrid(int rows, int cols, int seedPercentage) {
        int totalCells = rows * cols;
        int aliveCells = (totalCells * seedPercentage) / 100;
        cells = new ArrayList<>();
        List<Cell> allCells = new ArrayList<>();

        for (int i = 0; i < totalCells; i++) {
            if (aliveCells > 0) {
                allCells.add(new Cell(true));
                aliveCells--;
            } else {
                allCells.add(new Cell(false));
            }
        }

        Collections.shuffle(allCells);

        for (int i = 0; i < rows; i++) {
            List<Cell> cellRow = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                cellRow.add(allCells.removeFirst());
            }
            cells.add(cellRow);
        }

        for (List<Cell> row : cells) {
            Collections.shuffle(row);
        }
    }

    public boolean areAllCellsDead() {
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                if (cell.isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }
}
