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

    public void updateGrid() {
        List<int[]> indexesToKill = new ArrayList<>();
        List<int[]> indexesToMakeAlive = new ArrayList<>();

        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; j < cells.get(i).size(); j++) {
                int aliveNeighbours = getAliveNeighbours(i, j);
                if(aliveNeighbours < 2 || aliveNeighbours > 3){
                    indexesToKill.add(new int[]{i, j});
                }else{
                    indexesToMakeAlive.add(new int[]{i, j});
                }
            }
        }

        for (int[] index : indexesToKill) {
            cells.get(index[0]).get(index[1]).kill();
        }
        for (int[] index : indexesToMakeAlive) {
            cells.get(index[0]).get(index[1]).makeAlive();
        }
    }

    private int getAliveNeighbours(int row, int col) {
        int aliveNeighbours = 0;
        int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}, // Vertical and horizontal neighbors
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // Diagonal neighbors
        };

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < cells.size() && newCol >= 0 && newCol < cells.get(newRow).size() && cells.get(newRow).get(newCol).isAlive()) {
                aliveNeighbours++;
            }
        }

        return aliveNeighbours;
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
