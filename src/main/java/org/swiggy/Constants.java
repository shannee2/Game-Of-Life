package org.swiggy;

public enum Constants {
    ALIVE("*"),
    DEAD("-"),
    SEPERATOR("-----------------------------------------------------------");

    private final String representation;

    Constants(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }
}