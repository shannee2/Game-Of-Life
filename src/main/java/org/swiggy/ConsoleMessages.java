package org.swiggy;

public enum ConsoleMessages {
    ALIVE("*"),
    DEAD("-"),
    SEPERATOR("-----------------------------------------------------------"),

    GRID_ROW_INPUT("Enter the number of rows in the grid: "),
    GRID_COLUMN_INPUT("Enter the number of columns in the grid: "),
    SEED_PERCENTAGE_INPUT("Enter the percentage of cells to be alive: "),

    INVALID_SEED_PERCENTAGE_ERROR("Seed percentage must be between 0 and 100."),
    INVALID_GRID_SIZE_ERROR("Grid rows and column must be positive.");

    private final String representation;

    ConsoleMessages(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }
}