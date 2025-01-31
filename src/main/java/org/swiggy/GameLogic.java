package org.swiggy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameLogic {
    Grid grid;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


    public GameLogic(int rows, int cols, int seedPercentage) {
        this.grid = new Grid(rows, cols, seedPercentage);
    }

    public void startGame() {
        grid.display();
        scheduler.scheduleAtFixedRate(() -> {
            grid.update();
            grid.display();
            if(grid.areAllCellsDead()){
                scheduler.shutdown();
            }
        }, 1, 1, TimeUnit.SECONDS);
    }
}
