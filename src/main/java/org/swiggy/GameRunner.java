package org.swiggy;

import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(ConsoleConst.GRID_ROW_INPUT.getRepresentation());
            int rows = sc.nextInt();
            System.out.println(ConsoleConst.GRID_COLUMN_INPUT.getRepresentation());
            int cols = sc.nextInt();
            System.out.println(ConsoleConst.SEED_PERCENTAGE_INPUT.getRepresentation());
            int seedPercentage = sc.nextInt();
            GameLogic gameLogic = new GameLogic(rows, cols, seedPercentage);
            gameLogic.startGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
