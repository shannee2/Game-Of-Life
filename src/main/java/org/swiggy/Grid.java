package org.swiggy;

import org.swiggy.exceptions.InvalidGridSizeException;
import org.swiggy.exceptions.InvalidSeedPercentageException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grid {
    List<List<Cell>> grid;

    public Grid(int rows, int cols, int seedPercentage) {
        if(seedPercentage <= 0 || seedPercentage > 100){
            throw new InvalidSeedPercentageException();
        }
        if (rows <= 0 || cols <= 0) {
            throw new InvalidGridSizeException();
        }
        initializeGrid(rows, cols, seedPercentage);
    }

//    Another constructor

    private void initializeGrid(int rows, int cols, int seedPercentage) {
        int totalCells = rows * cols;
        int aliveCells = (totalCells * seedPercentage) / 100;
        grid = new ArrayList<>();
        List<Cell> allCells = new ArrayList<>();

        for (int i = 0; i < totalCells; i++) {
            allCells.add(new Cell(i < aliveCells));
        }

        Collections.shuffle(allCells);

        for (int i = 0; i < rows; i++) {
            List<Cell> cellRow = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                cellRow.add(allCells.remove(0));
            }
            grid.add(cellRow);
        }
    }

    public void update() {
        List<List<Cell>> tempGrid = new ArrayList<>();

        for (int i = 0; i < grid.size(); i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < grid.get(i).size(); j++) {
                row.add(grid.get(i).get(j).getNextState(getAllNeighbours(i,j)));
            }
            tempGrid.add(row);
        }
        this.grid = tempGrid;
    }

    private List<Cell> getAllNeighbours(int row, int col) {
        List<Cell> neighbours = new ArrayList<>();
        int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}, // Vertical and horizontal neighbors
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // Diagonal neighbors
        };

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < grid.size() && newCol >= 0 && newCol < grid.get(newRow).size()) {
                neighbours.add(grid.get(newRow).get(newCol));
            }
        }

        return neighbours;
    }

    public boolean areAllCellsDead() {
        for (List<Cell> row : grid) {
            for (Cell cell : row) {
                if (cell.isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void display(){
        for (List<Cell> row : grid) {
            for (Cell cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
