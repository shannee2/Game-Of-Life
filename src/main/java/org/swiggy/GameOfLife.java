package org.swiggy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameOfLife {
    private final Grid grid;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


    public GameOfLife(int rows, int cols, int seedPercentage) {
        this.grid = new Grid(rows, cols, seedPercentage);
    }

    public void startGame() {
        grid.display();
        scheduler.scheduleAtFixedRate(() -> {
            grid.update();
            grid.display();
            System.out.println(ConsoleMessages.SEPERATOR.getRepresentation());
            if(grid.areAllCellsDead()){
                scheduler.shutdown();
            }
        }, 1, 1, TimeUnit.SECONDS);
    }
}
