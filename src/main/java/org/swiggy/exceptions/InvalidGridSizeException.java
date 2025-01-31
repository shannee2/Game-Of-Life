package org.swiggy.exceptions;

import org.swiggy.ConsoleConst;

public class InvalidGridSizeException extends IllegalArgumentException {
    public InvalidGridSizeException() {
        super(ConsoleConst.INVALID_GRID_SIZE_ERROR.getRepresentation());
    }
}
