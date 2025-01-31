package org.swiggy;

public class GameLogic {
    Grid grid;

    public GameLogic(int rows, int cols, int seedPercentage) {
        this.grid = new Grid(rows, cols, seedPercentage);
    }
}
