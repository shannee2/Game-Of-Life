package org.swiggy;

public class Cell {
    private boolean isAlive;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Cell() {
        this.isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void makeAlive() {
        this.isAlive = true;
    }

    @Override
    public String toString() {
        return isAlive ? Characters.ALIVE.getRepresentation() : Characters.DEAD.getRepresentation();
    }
}
