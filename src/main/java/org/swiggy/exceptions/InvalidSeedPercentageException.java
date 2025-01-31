package org.swiggy.exceptions;

import org.swiggy.ConsoleConst;

public class InvalidSeedPercentageException extends IllegalArgumentException {
    public InvalidSeedPercentageException() {
        super(ConsoleConst.INVALID_SEED_PERCENTAGE_ERROR.getRepresentation());
    }
}
