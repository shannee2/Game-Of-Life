package org.swiggy;

public enum Characters {
    ALIVE("*"),
    DEAD("-");

    private final String representation;

    Characters(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }
}