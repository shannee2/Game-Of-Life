package org.swiggy;

import java.util.Scanner;

public class GameRunner {
    private final Grid grid;

    public GameRunner(int rows, int cols, int seedPercentage) {
        this.grid = new Grid(rows, cols, seedPercentage);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            grid.display();
            System.out.println(ConsoleMessages.ENTER_FOR_NEXT_GENERATION.getRepresentation());
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                System.out.println(ConsoleMessages.GAME_OVER.getRepresentation());
                break;
            }
            grid.update();
            if (grid.areAllCellsDead()) {
                System.out.println(ConsoleMessages.GAME_OVER.getRepresentation());
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
            sc.nextLine();

            GameRunner game = new GameRunner(rows, cols, seedPercentage);
            game.startGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
