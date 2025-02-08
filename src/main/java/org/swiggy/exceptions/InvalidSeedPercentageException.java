package org.swiggy.exceptions;

import org.swiggy.ConsoleMessages;

public class InvalidSeedPercentageException extends IllegalArgumentException {
    public InvalidSeedPercentageException() {
        super(ConsoleMessages.INVALID_SEED_PERCENTAGE_ERROR.getRepresentation());
    }
}
