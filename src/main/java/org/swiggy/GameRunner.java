package org.swiggy;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameRunner {
    private final Grid grid;

    public GameRunner(int rows, int cols, int seedPercentage) {
        this.grid = new Grid(rows, cols, seedPercentage);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            grid.display();
            System.out.println("Press Enter for next generation or type 'exit' to quit:");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
            grid.update();
            if (grid.areAllCellsDead()) {
                System.out.println("All cells are dead. Game over.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(ConsoleMessages.GRID_ROW_INPUT.getRepresentation());
            int rows = sc.nextInt();
            System.out.println(ConsoleMessages.GRID_COLUMN_INPUT.getRepresentation());
            int cols = sc.nextInt();
            System.out.println(ConsoleMessages.SEED_PERCENTAGE_INPUT.getRepresentation());
            int seedPercentage = sc.nextInt();
            sc.nextLine(); // Consume newline

            GameRunner game = new GameRunner(rows, cols, seedPercentage);
            game.startGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
