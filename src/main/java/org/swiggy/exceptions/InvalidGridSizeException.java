package org.swiggy.exceptions;

import org.swiggy.ConsoleMessages;

public class InvalidGridSizeException extends IllegalArgumentException {
    public InvalidGridSizeException() {
        super(ConsoleMessages.INVALID_GRID_SIZE_ERROR.getRepresentation());
    }
}
