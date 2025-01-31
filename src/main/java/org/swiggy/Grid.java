package org.swiggy;

import org.swiggy.exceptions.InvalidSeedPercentageException;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    List<List<Cell>> cells;


    public Grid(int rows, int cols, int seedPercentage) {
        if(seedPercentage<=0){
            throw new InvalidSeedPercentageException();
        }
        if (rows <= 0 ||cols <= 0) {
            throw new org.swiggy.exceptions.InvalidGridSizeException();
        }
        initializeGrid(rows, cols);
    }

    private void initializeGrid(int rows, int cols) {
        cells = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(new Cell());
            }
            cells.add(row);
        }
    }

    public boolean areAllCellsDead() {
        return true;
    }
}
